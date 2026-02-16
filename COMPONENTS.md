# Web Awesome Component Tracking

Tracks implementation progress for all Web Awesome v3.2.1 components.

**Legend:**
- Tag = `wa-*` tag defined in `WebAwesome.scala` (jvm + js)
- Scenario = scenario page exists in the scenario server
- Attrs = all WA-specific attributes defined (standard HTML attrs come from scalatags)

Note: `size` and `label` conflict with scalatags builtins — use `attr("size")` / `attr("label")` inline.

## Form Controls

| Component | Tag | Scenario | Attrs | WA-specific attrs needed |
|-----------|-----|----------|-------|--------------------------|
| wa-checkbox | [x] | [x] | [x] | indeterminate |
| wa-color-picker | [x] | [x] | [x] | format, without-format-toggle, open, opacity, uppercase, swatches |
| wa-input | [x] | [x] | [x] | without-spin-buttons, with-label, with-hint |
| wa-number-input | [x] | [x] | [x] | without-steppers, with-label, with-hint |
| wa-radio | [x] | [x] | [x] | (none) |
| wa-radio-group | [x] | [x] | [x] | (none) |
| wa-select | [x] | [x] | [x] | clearable, with-label, with-hint |
| wa-option | [x] | [x] | [x] | (none) |
| wa-slider | [x] | [x] | [x] | tooltip |
| wa-switch | [x] | [x] | [x] | (none) |
| wa-textarea | [x] | [x] | [x] | with-label, with-hint |

## Actions

| Component | Tag | Scenario | Attrs | WA-specific attrs needed |
|-----------|-----|----------|-------|--------------------------|
| wa-button | [x] | [x] | [x] | (none) |
| wa-button-group | [x] | [x] | [x] | orientation |
| wa-copy-button | [x] | [x] | [x] | from, copy-label, success-label, error-label, feedback-duration, tooltip-placement |
| wa-dropdown | [x] | [x] | [x] | open, placement, distance, skidding |
| wa-dropdown-item | [x] | [x] | [x] | submenu-open |

## Display & Feedback

| Component | Tag | Scenario | Attrs | WA-specific attrs needed |
|-----------|-----|----------|-------|--------------------------|
| wa-avatar | [x] | [x] | [x] | image, initials, shape |
| wa-badge | [x] | [x] | [x] | attention |
| wa-callout | [x] | [x] | [x] | (uses variant, appearance — already defined) |
| wa-icon | [x] | [x] | [x] | family, auto-width, swap-opacity, library, rotate, flip, animation |
| wa-skeleton | [x] | [x] | [x] | effect |
| wa-spinner | [x] | [x] | [x] | (none) |
| wa-tag | [x] | [x] | [x] | removable |

## Indicators & Progress

| Component | Tag | Scenario | Attrs | WA-specific attrs needed |
|-----------|-----|----------|-------|--------------------------|
| wa-progress-bar | [x] | [x] | [x] | (none — uses value, label) |
| wa-progress-ring | [x] | [x] | [x] | (none — uses value, label) |
| wa-rating | [x] | [x] | [x] | (none — uses value, readonly, disabled, label) |

## Layout & Organization

| Component | Tag | Scenario | Attrs | WA-specific attrs needed |
|-----------|-----|----------|-------|--------------------------|
| wa-breadcrumb | [x] | [x] | [x] | (none — uses label) |
| wa-breadcrumb-item | [x] | [x] | [x] | (none — uses href, target, rel) |
| wa-card | [x] | [x] | [x] | with-header, with-media, with-footer, orientation |
| wa-details | [x] | [x] | [x] | open, summary, icon-placement |
| wa-dialog | [x] | [x] | [x] | open |
| wa-divider | [x] | [x] | [x] | orientation |
| wa-drawer | [x] | [x] | [x] | open, placement |
| wa-split-panel | [x] | [x] | [x] | position, vertical |

## Navigation

| Component | Tag | Scenario | Attrs | WA-specific attrs needed |
|-----------|-----|----------|-------|--------------------------|
| wa-tab | [x] | [x] | [x] | panel |
| wa-tab-group | [x] | [x] | [x] | activation, placement, without-scroll-controls |
| wa-tab-panel | [x] | [x] | [x] | (none — uses name) |
| wa-tree | [x] | [x] | [x] | selection, lazy |
| wa-tree-item | [x] | [x] | [x] | expanded, lazy |

## Popups & Overlays

| Component | Tag | Scenario | Attrs | WA-specific attrs needed |
|-----------|-----|----------|-------|--------------------------|
| wa-popover | [x] | [x] | [x] | placement, open, distance, skidding, without-arrow |
| wa-popup | [x] | [x] | [x] | anchor, active, placement, boundary, distance, skidding, arrow, arrow-placement, arrow-padding, flip, flip-fallback-placements, flip-fallback-strategy, flip-padding, shift, shift-padding, auto-size, sync, auto-size-padding, hover-bridge |
| wa-tooltip | [x] | [x] | [x] | placement, trigger, distance, skidding, hoist |

## Media

| Component | Tag | Scenario | Attrs | WA-specific attrs needed |
|-----------|-----|----------|-------|--------------------------|
| wa-animated-image | [ ] | [ ] | [ ] | play |
| wa-animation | [ ] | [ ] | [ ] | play, delay, direction, duration, easing, end-delay, fill, iterations, iteration-start, keyframes, playback-rate |
| wa-carousel | [ ] | [ ] | [ ] | loop, navigation, pagination, autoplay, autoplay-interval, slides-per-page, slides-per-move, orientation, mouse-dragging |
| wa-carousel-item | [ ] | [ ] | [x] | (none) |
| wa-comparison | [ ] | [ ] | [ ] | position |

## Formatters & Utilities

| Component | Tag | Scenario | Attrs | WA-specific attrs needed |
|-----------|-----|----------|-------|--------------------------|
| wa-format-bytes | [ ] | [ ] | [ ] | unit, display |
| wa-format-date | [ ] | [ ] | [ ] | date, weekday, era, year, month, day, hour, minute, second, time-zone-name, time-zone, hour-format |
| wa-format-number | [ ] | [ ] | [ ] | without-grouping, currency, currency-display, minimum-integer-digits, minimum-fraction-digits, maximum-fraction-digits, minimum-significant-digits, maximum-significant-digits |
| wa-include | [ ] | [ ] | [ ] | mode, allow-scripts |
| wa-qr-code | [ ] | [ ] | [ ] | fill, background |
| wa-relative-time | [ ] | [ ] | [ ] | date, locale, format |
| wa-zoomable-frame | [ ] | [ ] | [x] | (none — uses src, alt) |

## Observers (utility components)

| Component | Tag | Scenario | Attrs | WA-specific attrs needed |
|-----------|-----|----------|-------|--------------------------|
| wa-intersection-observer | [ ] | [ ] | [ ] | root, root-margin, threshold, intersect-class, once |
| wa-mutation-observer | [ ] | [ ] | [ ] | attr, attr-old-value, char-data, char-data-old-value, child-list |
| wa-resize-observer | [ ] | [ ] | [x] | (none) |
| wa-scroller | [ ] | [ ] | [ ] | orientation |

## Pro Components

| Component | Tag | Scenario | Attrs | WA-specific attrs needed |
|-----------|-----|----------|-------|--------------------------|
| wa-combobox | [ ] | [ ] | [ ] | max-options-visible, with-clear, open, placement, with-label, with-hint, allow-custom-value |
| wa-file-input | [ ] | [ ] | [ ] | with-label, with-hint |
| wa-page | [ ] | [ ] | [ ] | view, nav-open, mobile-breakpoint, navigation-placement, disable-navigation-toggle |
| wa-sparkline | [ ] | [ ] | [ ] | data, trend, curve |

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
- **Tags defined**: 18 / 61
- **Scenarios created**: 5 / 61
- **Fully attributed**: 11 / 61 (mostly components with no WA-specific attrs)
