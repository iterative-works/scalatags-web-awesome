---
name: iw-cli-ops
description: |
  Fetch issue descriptions, manage development worktrees, and run project health checks.

  Use when:
  - User asks to read, plan, or discuss an issue (e.g., "read the issue", "let's plan WA-48")
  - Need issue description, title, status, or details from the tracker
  - Starting work on an issue (creates isolated worktree + tmux session)
  - Opening, removing, or registering worktrees
  - Checking project health or environment setup ("run doctor")
  - Querying project configuration values
  - Managing the dashboard server lifecycle
  - Managing review-state.json files (validate, write, update)
  - Creating issues in the tracker
  - Submitting feedback about iw-cli itself
---

# iw-cli Operations

iw-cli is a project-local CLI tool for issue tracking, worktree management, and development
workflow automation. It is invoked as `./iw` from the project root (NOT `iw` — it's not in PATH).

## Project Context

This project uses:
- **Tracker**: GitHub (`iterative-works/scalatags-web-awesome`)
- **Team prefix**: `WA`
- **Project name**: `scalatags-web-awesome`

## Command Reference

### Issue Operations

#### Fetch issue details
```bash
./iw issue [issue-id]
```
- Without args: infers issue ID from current git branch
- With ID: fetches that specific issue (e.g., `./iw issue 42` or `./iw issue WA-42`)
- For GitHub/GitLab trackers, the team prefix is applied automatically

#### Create a new issue
```bash
./iw issue create --title "Issue title" [--description "Details"]
```

### Worktree Operations

#### Start working on an issue
```bash
./iw start <issue-id>
```
Creates a git worktree in a sibling directory, creates a new branch (or uses existing), sets up a tmux session, and switches to it.

#### Open existing worktree
```bash
./iw open [issue-id]
```
Opens (or creates) a tmux session for an existing worktree. Without args, infers issue from current branch.

#### Remove a worktree
```bash
./iw rm <issue-id> [--force]
```
Kills the tmux session, checks for uncommitted changes, removes the worktree. Use `--force` to skip safety checks.

#### Register current worktree with dashboard
```bash
./iw register
```
Auto-detects issue ID from current branch and registers with the dashboard server.

### Environment & Configuration

#### Check project health
```bash
./iw doctor [--fix] [--quality] [--env]
```
Validates git repo, configuration, and extensible hook checks. Use `--fix` to launch Claude-assisted remediation.

#### Query configuration
```bash
./iw config get <field>    # Get a specific field
./iw config --json         # Export full config as JSON
```
Fields: `tracker.trackerType`, `tracker.team`, `tracker.repository`, `tracker.teamPrefix`, `project.name`, `version`

#### Initialize project
```bash
./iw init [--force] [--tracker=github] [--repository=owner/repo] [--team-prefix=WA]
```
Interactive or flag-driven setup of `.iw/config.conf`. Supports GitHub, GitLab, Linear, and YouTrack trackers.

### Dashboard Server

#### Manage the background server
```bash
./iw server start    # Start dashboard server daemon
./iw server stop     # Stop it
./iw server status   # Show running state
```

#### Run dashboard in foreground
```bash
./iw dashboard [--dev] [--sample-data] [--state-path <path>]
```
Starts the dashboard web UI and opens a browser. Use `--dev` for isolated testing.

### Review State Management

#### Validate review-state.json
```bash
./iw review-state validate <file-path>
./iw review-state validate --stdin
```

#### Create review-state.json
```bash
./iw review-state write --display-text "Planning" --display-type info [--output <path>]
```
Auto-populates `issue_id`, `git_sha`, and `last_updated` from git context.

#### Update existing review-state.json
```bash
./iw review-state update --display-text "Implementing"
./iw review-state update --append-artifact "Tasks:phase-02-tasks.md"
./iw review-state update --clear-message
```
Supports replace, append, and clear modes for array fields (badges, artifacts, actions, task-lists, checkpoints).

### Other Commands

#### Version info
```bash
./iw version [--verbose]
```

#### Submit feedback about iw-cli
```bash
./iw feedback "Title" [--description "Details"] [--type bug|feature]
```
Creates an issue in the iw-cli GitHub repository.

#### Run tests
```bash
./iw test [unit|compile|e2e]
```
Runs unit tests, command compilation checks, and/or BATS E2E tests.

#### Get command details
```bash
./iw --describe <command>
```
Shows detailed information about any command.

## Common Workflows

### Fetch an issue to read or plan work
```bash
./iw issue WA-42          # Fetch issue #42
./iw issue                # Fetch issue for current branch
```

### Start a new feature
```bash
./iw start WA-42          # Creates worktree + tmux session
# ... work in the worktree ...
./iw open WA-42           # Re-attach if detached
./iw rm WA-42             # Clean up when done
```

### Check project setup
```bash
./iw doctor               # Run all checks
./iw doctor --fix         # Auto-fix quality gate failures
```
