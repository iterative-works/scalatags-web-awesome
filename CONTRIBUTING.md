# Contributing

## CI Checks

Pull requests to `main` trigger a GitHub Actions workflow with four jobs:

| Job       | Command                  | Runs        |
|-----------|--------------------------|-------------|
| compile   | `./mill __.compile`      | in parallel |
| format    | `./mill __.checkFormat`  | in parallel |
| lint      | `./mill __.fix --check`  | in parallel |
| test      | `./mill __.test`         | after compile |

All four must pass before merging.

## Git Hooks

Install the shared hooks:

```sh
git config core.hooksPath .git-hooks
```

### pre-commit

Runs `./mill __.checkFormat` to catch formatting issues before they reach CI.
Takes ~10 seconds.

### pre-push

1. Clean compiles all modules and blocks if any `[warn]` output is found.
2. Runs the full test suite (`./mill __.test`).

Takes ~3 minutes.

## Local Development

Run these commands to check your work before committing:

```sh
# Check formatting
./mill __.checkFormat

# Auto-format all sources
./mill __.reformat

# Lint (scalafix)
./mill __.fix --check

# Auto-fix lint issues
./mill __.fix

# Run tests
./mill __.test
```

## Troubleshooting

### Hook not running

Verify the hooks path is configured:

```sh
git config core.hooksPath
# Should print: .git-hooks
```

If not, run `git config core.hooksPath .git-hooks` again.

Also check that the hook scripts are executable:

```sh
ls -l .git-hooks/
# Both files should have the x permission bit
chmod +x .git-hooks/*
```

### Format failures after merge or rebase

Run `./mill __.reformat` to fix formatting, then stage the changes:

```sh
./mill __.reformat
git add -u
```

### Scalafix failures

Run `./mill __.fix` to auto-apply fixes, then review and stage the changes.
