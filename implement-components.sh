#!/usr/bin/env bash
# PURPOSE: Automate component implementation by calling Claude for each component.
# PURPOSE: Reads COMPONENTS.md, finds next incomplete component, delegates work.
set -euo pipefail

cd "$(dirname "$0")"

COMPONENTS_FILE="COMPONENTS.md"
MODEL="sonnet"

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

count_remaining() {
    grep '| wa-' "$COMPONENTS_FILE" | grep -c '\[ \]' || echo 0
}

# --- Main ---

echo "=== Web Awesome Component Implementation ==="
echo "Remaining unchecked boxes: $(count_remaining)"

while true; do
    component=$(find_next_component) || break

    status_line=$(get_status_line "$component")
    scala_name=$(to_scala_name "$component")
    remaining=$(count_remaining)

    # Extract which boxes are unchecked
    tag_done=$(echo "$status_line" | awk -F'|' '{print $3}' | grep -c '\[x\]' || true)
    scenario_done=$(echo "$status_line" | awk -F'|' '{print $4}' | grep -c '\[x\]' || true)
    attrs_done=$(echo "$status_line" | awk -F'|' '{print $5}' | grep -c '\[x\]' || true)
    attrs_needed=$(echo "$status_line" | awk -F'|' '{gsub(/^[ \t]+|[ \t]+$/,"",$6); print $6}')

    echo ""
    echo "============================================="
    echo "[$remaining remaining] $component ($scala_name)"
    echo "Status: $status_line"
    echo "Tag: $([ "$tag_done" -eq 1 ] && echo DONE || echo TODO)"
    echo "Attrs: $([ "$attrs_done" -eq 1 ] && echo DONE || echo "TODO: $attrs_needed")"
    echo "Scenario: $([ "$scenario_done" -eq 1 ] && echo DONE || echo TODO)"
    echo "============================================="

    # Build task list for this component
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
6. After completing all tasks, update COMPONENTS.md: change [ ] to [x] for each task you completed on the row for $component.
7. Run ./mill webawesome.jvm.test to verify nothing is broken.
8. Keep tag definitions in the same order/grouping as existing ones. For new categories, add a comment.
9. If attrs say \"(none)\" or similar, just check the attrs box — no new attrs needed.
10. For scenario content, check node_modules/@awesome.me/webawesome-pro/dist/custom-elements.json (grep for the component name) to understand the component's API if needed.

## Output
When done, output exactly: DONE: $component
If you hit an unresolvable error, output exactly: FAIL: $component: <reason>"

    # Run claude
    if ! claude -p --model "$MODEL" --allowedTools "Edit,Write,Bash,Read,Glob,Grep" <<< "$prompt"; then
        echo "FAILED: Claude exited with error for $component"
        exit 1
    fi

    # Verify progress was made
    new_status_line=$(get_status_line "$component")
    if [[ "$status_line" == "$new_status_line" ]]; then
        echo ""
        echo "FAILED: No progress on $component"
        echo "Before: $status_line"
        echo "After:  $new_status_line"
        exit 1
    fi

    # Commit progress
    git add -A
    git commit -m "$(cat <<EOF
Add $component component (tag, attrs, scenario)

Co-Authored-By: Claude Sonnet 4.5 <noreply@anthropic.com>
EOF
)" || true  # Don't fail if nothing to commit

    echo ""
    echo "PROGRESS: $new_status_line"
done

echo ""
echo "========================================="
echo "ALL COMPONENTS COMPLETE!"
echo "========================================="
