# Web Awesome Component Tracking

Tracks implementation progress for all Web Awesome v3.2.1 components.

**Legend:**
- Tag = `wa-*` tag defined in `WebAwesome.scala` (jvm + js)
- Scenario = scenario page exists in the scenario server
- Attrs = all WA-specific attributes defined (standard HTML attrs come from scalatags)
- Review = scenario visually verified with Playwright (components render, no console errors)

Note: `size` and `label` conflict with scalatags builtins — use `attr("size")` / `attr("label")` inline.

## Form Controls

| Component | Tag | Scenario | Attrs | Review | WA-specific attrs needed |
|-----------|-----|----------|-------|--------|--------------------------|
| wa-checkbox | [x] | [x] | [x] | [x] | indeterminate |
| wa-color-picker | [x] | [x] | [x] | [x] | format, without-format-toggle, open, opacity, uppercase, swatches |
| wa-input | [x] | [x] | [x] | [x] | without-spin-buttons, with-label, with-hint |
| wa-number-input | [x] | [x] | [x] | [x] | without-steppers, with-label, with-hint |
| wa-radio | [x] | [x] | [x] | [x] | (none) |
| wa-radio-group | [x] | [x] | [x] | [x] | (none) |
| wa-select | [x] | [x] | [x] | [x] | clearable, with-label, with-hint |
| wa-option | [x] | [x] | [x] | [x] | (none) |
| wa-slider | [x] | [x] | [x] | [x] | tooltip |
| wa-switch | [x] | [x] | [x] | [x] | (none) |
| wa-textarea | [x] | [x] | [x] | [x] | with-label, with-hint |

## Actions

| Component | Tag | Scenario | Attrs | Review | WA-specific attrs needed |
|-----------|-----|----------|-------|--------|--------------------------|
| wa-button | [x] | [x] | [x] | [x] | (none) |
| wa-button-group | [x] | [x] | [x] | [x] | orientation |
| wa-copy-button | [x] | [x] | [x] | [x] | from, copy-label, success-label, error-label, feedback-duration, tooltip-placement |
| wa-dropdown | [x] | [x] | [x] | [x] | open, placement, distance, skidding |
| wa-dropdown-item | [x] | [x] | [x] | [x] | submenu-open |

## Display & Feedback

| Component | Tag | Scenario | Attrs | Review | WA-specific attrs needed |
|-----------|-----|----------|-------|--------|--------------------------|
| wa-avatar | [x] | [x] | [x] | [x] | image, initials, shape |
| wa-badge | [x] | [x] | [x] | [x] | attention |
| wa-callout | [x] | [x] | [x] | [x] | (uses variant, appearance — already defined) |
| wa-icon | [x] | [x] | [x] | [x] | family, auto-width, swap-opacity, library, rotate, flip, animation |
| wa-skeleton | [x] | [x] | [x] | [x] | effect |
| wa-spinner | [x] | [x] | [x] | [x] | (none) |
| wa-tag | [x] | [x] | [x] | [x] | removable |

## Indicators & Progress

| Component | Tag | Scenario | Attrs | Review | WA-specific attrs needed |
|-----------|-----|----------|-------|--------|--------------------------|
| wa-progress-bar | [x] | [x] | [x] | [x] | (none — uses value, label) |
| wa-progress-ring | [x] | [x] | [x] | [x] | (none — uses value, label) |
| wa-rating | [x] | [x] | [x] | [x] | (none — uses value, readonly, disabled, label) |

## Layout & Organization

| Component | Tag | Scenario | Attrs | Review | WA-specific attrs needed |
|-----------|-----|----------|-------|--------|--------------------------|
| wa-breadcrumb | [x] | [x] | [x] | [x] | (none — uses label) |
| wa-breadcrumb-item | [x] | [x] | [x] | [x] | (none — uses href, target, rel) |
| wa-card | [x] | [x] | [x] | [x] | with-header, with-media, with-footer, orientation |
| wa-details | [x] | [x] | [x] | [x] | open, summary, icon-placement |
| wa-dialog | [x] | [x] | [x] | [x] | open |
| wa-divider | [x] | [x] | [x] | [x] | orientation |
| wa-drawer | [x] | [x] | [x] | [x] | open, placement |
| wa-split-panel | [x] | [x] | [x] | [x] | position, vertical |

## Navigation

| Component | Tag | Scenario | Attrs | Review | WA-specific attrs needed |
|-----------|-----|----------|-------|--------|--------------------------|
| wa-tab | [x] | [x] | [x] | [x] | panel |
| wa-tab-group | [x] | [x] | [x] | [x] | activation, placement, without-scroll-controls |
| wa-tab-panel | [x] | [x] | [x] | [x] | (none — uses name) |
| wa-tree | [x] | [x] | [x] | [x] | selection, lazy |
| wa-tree-item | [x] | [x] | [x] | [x] | expanded, lazy |

## Popups & Overlays

| Component | Tag | Scenario | Attrs | Review | WA-specific attrs needed |
|-----------|-----|----------|-------|--------|--------------------------|
| wa-popover | [x] | [x] | [x] | [x] | placement, open, distance, skidding, without-arrow |
| wa-popup | [x] | [x] | [x] | [x] | anchor, active, placement, boundary, distance, skidding, arrow, arrow-placement, arrow-padding, flip, flip-fallback-placements, flip-fallback-strategy, flip-padding, shift, shift-padding, auto-size, sync, auto-size-padding, hover-bridge |
| wa-tooltip | [x] | [x] | [x] | [x] | placement, trigger, distance, skidding, hoist |

## Media

| Component | Tag | Scenario | Attrs | Review | WA-specific attrs needed |
|-----------|-----|----------|-------|--------|--------------------------|
| wa-animated-image | [x] | [x] | [x] | [x] | play |
| wa-animation | [x] | [x] | [x] | [x] | play, delay, direction, duration, easing, end-delay, fill, iterations, iteration-start, keyframes, playback-rate |
| wa-carousel | [x] | [x] | [x] | [x] | loop, navigation, pagination, autoplay, autoplay-interval, slides-per-page, slides-per-move, orientation, mouse-dragging |
| wa-carousel-item | [x] | [x] | [x] | [x] | (none) |
| wa-comparison | [x] | [x] | [x] | [x] | position |

## Formatters & Utilities

| Component | Tag | Scenario | Attrs | Review | WA-specific attrs needed |
|-----------|-----|----------|-------|--------|--------------------------|
| wa-format-bytes | [x] | [x] | [x] | [x] | unit, display |
| wa-format-date | [x] | [x] | [x] | [x] | date, weekday, era, year, month, day, hour, minute, second, time-zone-name, time-zone, hour-format |
| wa-format-number | [x] | [x] | [x] | [x] | without-grouping, currency, currency-display, minimum-integer-digits, minimum-fraction-digits, maximum-fraction-digits, minimum-significant-digits, maximum-significant-digits |
| wa-include | [x] | [x] | [x] | [x] | mode, allow-scripts |
| wa-qr-code | [x] | [x] | [x] | [x] | radius, error-correction (fill already defined; background conflicts) |
| wa-relative-time | [x] | [x] | [x] | [x] | date, format, numeric, sync (locale not needed for component) |
| wa-zoomable-frame | [x] | [x] | [x] | [ ] | zoom, zoom-levels, without-controls, without-interaction |

## Observers (utility components)

| Component | Tag | Scenario | Attrs | Review | WA-specific attrs needed |
|-----------|-----|----------|-------|--------|--------------------------|
| wa-intersection-observer | [x] | [x] | [x] | [ ] | root, root-margin, threshold, intersect-class, once |
| wa-mutation-observer | [x] | [x] | [x] | [ ] | attr, attr-old-value, char-data, char-data-old-value, child-list |
| wa-resize-observer | [x] | [x] | [x] | [ ] | (none) |
| wa-scroller | [x] | [x] | [x] | [ ] | orientation |

## Pro Components

| Component | Tag | Scenario | Attrs | Review | WA-specific attrs needed |
|-----------|-----|----------|-------|--------|--------------------------|
| wa-combobox | [x] | [x] | [x] | [ ] | max-options-visible, with-clear, open, placement, with-label, with-hint, allow-custom-value |
| wa-file-input | [x] | [x] | [x] | [ ] | with-label, with-hint |
| wa-page | [x] | [x] | [x] | [ ] | view, nav-open, mobile-breakpoint, navigation-placement, disable-navigation-toggle |
| wa-sparkline | [x] | [x] | [x] | [ ] | trend, curve (data conflicts with scalatags — use attr("data")) |

## Shared WA-specific attrs (already defined in Attrs trait)

These attrs are used across multiple components:
- `slot` — web component standard
- `appearance` — visual style (accent, filled, outlined, plain)
- `variant` — semantic color (neutral, brand, success, warning, danger)
- `pill` — rounded shape
- `loading` — loading state
- `withCaret` — dropdown caret indicator
- `lightDismiss` — close on outside click (dialog, drawer)
- `withoutHeader` — hide header (dialog, drawer)
- `hint` — help text (input, select, checkbox, textarea)
- `withClear` — show clear button (input)
- `passwordToggle` — show/hide password (input)
- `passwordVisible` — password initially visible (input)

## Attrs still needed (shared across components)

- `open` — dialog, drawer, details, dropdown, color-picker, popover
- `placement` — drawer, dropdown, tooltip, popover, popup, tab-group
- `orientation` — divider, button-group, carousel, scroller
- `removable` — tag
- `clearable` — select
- `withLabel` / `withHint` — input, number-input, select, textarea
- ... and many component-specific attrs listed above

## Summary

- **Total components**: 61 (including 4 Pro)
- **Tags defined**: 61 / 61
- **Scenarios created**: 61 / 61
- **Fully attributed**: 61 / 61
- **Reviewed**: 0 / 61
