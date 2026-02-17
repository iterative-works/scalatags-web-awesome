#!/usr/bin/env bash
# PURPOSE: Automate component implementation by calling Claude for each component.
# PURPOSE: Reads COMPONENTS.md, finds next incomplete component, delegates work.
set -euo pipefail

cd "$(dirname "$0")"

COMPONENTS_FILE="COMPONENTS.md"
MODEL="sonnet"
PLAYWRIGHT_MCP="$HOME/mcps/playwright.json"
BASE_URL="http://localhost:8086"

# --- Helpers ---

find_next_component() {
    local result
    result=$(grep '| wa-' "$COMPONENTS_FILE" | grep '\[ \]' | head -1 \
        | awk -F'|' '{gsub(/^[ \t]+|[ \t]+$/,"",$2); print $2}')
    if [[ -z "$result" ]]; then
        return 1
    fi
    echo "$result"
}

get_status_line() {
    grep "| $1 " "$COMPONENTS_FILE" | head -1
}

to_scala_name() {
    echo "$1" | sed 's/-\([a-z]\)/\U\1/g'
}

to_route() {
    # wa-button-group -> button-group
    echo "$1" | sed 's/^wa-//'
}

count_remaining() {
    grep '| wa-' "$COMPONENTS_FILE" | grep -c '\[ \]' || echo 0
}

needs_implementation() {
    local line="$1"
    # Check if any of columns 3-5 (tag, scenario, attrs) have [ ]
    echo "$line" | awk -F'|' '{
        tag=$3; scenario=$4; attrs=$5
        if (tag ~ /\[ \]/ || scenario ~ /\[ \]/ || attrs ~ /\[ \]/) print "yes"
        else print "no"
    }'
}

needs_review() {
    local line="$1"
    # Check if column 6 (review) has [ ]
    echo "$line" | awk -F'|' '{
        review=$6
        if (review ~ /\[ \]/) print "yes"
        else print "no"
    }'
}

# --- Main ---

echo "=== Web Awesome Component Implementation ==="
echo "Remaining unchecked boxes: $(count_remaining)"

while true; do
    component=$(find_next_component) || break

    status_line=$(get_status_line "$component")
    scala_name=$(to_scala_name "$component")
    route=$(to_route "$component")
    remaining=$(count_remaining)

    impl_needed=$(needs_implementation "$status_line")
    review_needed=$(needs_review "$status_line")

    if [[ "$impl_needed" == "yes" ]]; then
        # --- Implementation phase (tag, attrs, scenario) ---
        tag_done=$(echo "$status_line" | awk -F'|' '{print $3}' | grep -c '\[x\]' || true)
        scenario_done=$(echo "$status_line" | awk -F'|' '{print $4}' | grep -c '\[x\]' || true)
        attrs_done=$(echo "$status_line" | awk -F'|' '{print $5}' | grep -c '\[x\]' || true)
        attrs_needed=$(echo "$status_line" | awk -F'|' '{gsub(/^[ \t]+|[ \t]+$/,"",$7); print $7}')

        echo ""
        echo "============================================="
        echo "[$remaining remaining] IMPLEMENT: $component ($scala_name)"
        echo "Status: $status_line"
        echo "============================================="

        tasks=""
        if [[ "$tag_done" -eq 0 ]]; then
            tasks="${tasks}
- ADD TAG: Add \`lazy val $scala_name = htmlTag(\"$component\")\` to both webawesome/jvm/src/WebAwesome.scala and webawesome/js/src/WebAwesome.scala. Place it in the appropriate category section following existing patterns."
        fi
        if [[ "$attrs_done" -eq 0 ]]; then
            tasks="${tasks}
- ADD ATTRS: WA-specific attrs needed: $attrs_needed. Add them to webawesome/src/WebAwesome.scala (the shared Attrs trait). Use camelCase Scala names and kebab-case attr strings. Only add attrs NOT already defined in the trait and NOT already in scalatags. NEVER add \`size\` or \`label\` to the trait (they conflict with scalatags builtins — use \`attr(\"size\")\` / \`attr(\"label\")\` inline in scenarios)."
        fi
        if [[ "$scenario_done" -eq 0 ]]; then
            tasks="${tasks}
- ADD SCENARIO: Add a nav item to Layout.scala navItems and a new route to Server.scala. Follow existing demo page patterns. Show the component's key features (variants, sizes, appearances, states, slots). For attrs needing \`attr(\"size\")\` or \`attr(\"label\")\`, use them inline. Import any new attrs you added."
        fi

        prompt="You are implementing Web Awesome component bindings for a Scalatags library.

## Project Files
- webawesome/src/WebAwesome.scala — Shared Attrs trait (WA-specific attributes)
- webawesome/jvm/src/WebAwesome.scala — JVM tag definitions (Text backend)
- webawesome/js/src/WebAwesome.scala — JS tag definitions (JsDom backend)
- webawesome/jvm/test/src/SmokeTest.scala — Smoke tests
- scenarios/src/Server.scala — Cask scenario server with demo pages
- scenarios/src/Layout.scala — Page layout with sidebar nav
- COMPONENTS.md — Tracking document

## Component: $component (Scala: $scala_name)

Current status: $status_line

## Tasks
$tasks

## Rules
1. Read the existing files FIRST to understand patterns before making changes.
2. Match the existing code style EXACTLY.
3. Only define attrs that are WA-specific (not standard HTML like disabled, name, value, placeholder, type, href, src, checked, required, readonly, pattern, min, max, step, multiple, selected, autocomplete, autofocus, spellcheck, alt, rel, target, download, open).
4. size and label MUST NOT be added to the Attrs trait — they conflict with scalatags.
5. For the scenario, look at existing pages in Server.scala for the pattern. Demonstrate the component's most useful features.
6. After completing all tasks, update COMPONENTS.md: change [ ] to [x] for each task you completed on the row for $component. The Review column (column 6) has its own [ ] — do NOT touch it.
7. Run ./mill webawesome.jvm.test to verify nothing is broken.
8. Keep tag definitions in the same order/grouping as existing ones. For new categories, add a comment.
9. If attrs say \"(none)\" or similar, just check the attrs box — no new attrs needed.
10. For scenario content, check node_modules/@awesome.me/webawesome-pro/dist/custom-elements.json (grep for the component name) to understand the component's API if needed.

## Output
When done, output exactly: DONE: $component
If you hit an unresolvable error, output exactly: FAIL: $component: <reason>"

        if ! claude -p --model "$MODEL" --allowedTools "Edit,Write,Bash,Read,Glob,Grep" -- "$prompt"; then
            echo "FAILED: Claude exited with error for $component (implementation)"
            exit 1
        fi

        new_status_line=$(get_status_line "$component")
        if [[ "$status_line" == "$new_status_line" ]]; then
            echo ""
            echo "FAILED: No progress on $component (implementation)"
            echo "Before: $status_line"
            echo "After:  $new_status_line"
            exit 1
        fi

        git add -A
        git commit -m "$(cat <<EOF
Add $component component (tag, attrs, scenario)

Co-Authored-By: Claude Sonnet 4.5 <noreply@anthropic.com>
EOF
)" || true

        echo ""
        echo "IMPL OK: $new_status_line"

    elif [[ "$review_needed" == "yes" ]]; then
        # --- Review phase (Playwright visual verification) ---
        echo ""
        echo "============================================="
        echo "[$remaining remaining] REVIEW: $component (/$route)"
        echo "Status: $status_line"
        echo "============================================="

        review_prompt="You are reviewing a Web Awesome component scenario page using Playwright.

## Task
Visit $BASE_URL/$route and verify the $component scenario page renders correctly.

## Steps
1. Navigate to $BASE_URL/$route
2. Wait 3 seconds for Web Awesome components to hydrate
3. Take a screenshot to see the visual result
4. Check console messages for errors (ignore favicon 404)
5. Verify the page has meaningful content (not just plain text — components should be styled)
6. If there are problems:
   - Read scenarios/src/Server.scala to find the route for $route
   - Fix the Scala code causing the issue
   - Read scenarios/src/Layout.scala if layout changes are needed
   - Read webawesome/src/WebAwesome.scala and webawesome/jvm/src/WebAwesome.scala if attr/tag issues
   - After fixing, wait 10 seconds for Mill watch mode to recompile, then re-check
7. Once the page renders correctly with no significant console errors, update COMPONENTS.md: change [ ] to [x] in the Review column for $component.

## What counts as passing
- The wa-* components render as styled interactive elements (not plain text)
- No JavaScript errors in console (favicon 404 is OK, so are deprecation warnings)
- The page shows the expected demo sections

## What to fix
- If components show as unstyled text, the Web Awesome JS may not be loading — check the HTML head
- If attrs are wrong, fix in Server.scala
- If tags are missing, fix in WebAwesome.scala (both jvm and js)
- Run ./mill webawesome.jvm.test after any code changes

## Output
When done, output exactly: DONE: $component
If you hit an unresolvable error, output exactly: FAIL: $component: <reason>"

        if ! claude -p --model "$MODEL" \
            --allowedTools "Edit,Write,Bash,Read,Glob,Grep,mcp__playwright__browser_navigate,mcp__playwright__browser_snapshot,mcp__playwright__browser_take_screenshot,mcp__playwright__browser_console_messages,mcp__playwright__browser_wait_for,mcp__playwright__browser_click,mcp__playwright__browser_evaluate" \
            --mcp-config "$PLAYWRIGHT_MCP" \
            -- "$review_prompt"; then
            echo "FAILED: Claude exited with error for $component (review)"
            exit 1
        fi

        new_status_line=$(get_status_line "$component")
        if [[ "$status_line" == "$new_status_line" ]]; then
            echo ""
            echo "FAILED: No progress on $component (review)"
            echo "Before: $status_line"
            echo "After:  $new_status_line"
            exit 1
        fi

        git add -A
        git commit -m "$(cat <<EOF
Review $component scenario page

Co-Authored-By: Claude Sonnet 4.5 <noreply@anthropic.com>
EOF
)" || true

        echo ""
        echo "REVIEW OK: $new_status_line"
    fi
done

echo ""
echo "========================================="
echo "ALL COMPONENTS COMPLETE!"
echo "========================================="
