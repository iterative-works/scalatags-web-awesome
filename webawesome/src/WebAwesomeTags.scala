// PURPOSE: Shared tag definitions for all Web Awesome components.
// PURPOSE: Parameterized on scalatags Bundle so tags are defined once for both JVM and JS.
package works.iterative.scalatags.webawesome

import scalatags.generic.Bundle

abstract class WebAwesomeTags[Builder, Output <: FragT, FragT](
    val bundle: Bundle[Builder, Output, FragT]
) extends Attrs:
    import bundle.all.tag

    // Actions
    lazy val waButton = tag("wa-button")
    lazy val waButtonGroup = tag("wa-button-group")
    lazy val waCopyButton = tag("wa-copy-button")

    // Feedback
    lazy val waBadge = tag("wa-badge")
    lazy val waSpinner = tag("wa-spinner")
    lazy val waSkeleton = tag("wa-skeleton")
    lazy val waTag = tag("wa-tag")

    // Form controls
    lazy val waInput = tag("wa-input")
    lazy val waSwitch = tag("wa-switch")
    lazy val waCheckbox = tag("wa-checkbox")
    lazy val waSelect = tag("wa-select")
    lazy val waOption = tag("wa-option")
    lazy val waCombobox = tag("wa-combobox")
    lazy val waRadio = tag("wa-radio")
    lazy val waRadioGroup = tag("wa-radio-group")
    lazy val waColorPicker = tag("wa-color-picker")
    lazy val waNumberInput = tag("wa-number-input")
    lazy val waSlider = tag("wa-slider")
    lazy val waTextarea = tag("wa-textarea")
    lazy val waFileInput = tag("wa-file-input")

    // Organization
    lazy val waBreadcrumb = tag("wa-breadcrumb")
    lazy val waBreadcrumbItem = tag("wa-breadcrumb-item")
    lazy val waCard = tag("wa-card")
    lazy val waDialog = tag("wa-dialog")
    lazy val waDrawer = tag("wa-drawer")
    lazy val waDivider = tag("wa-divider")
    lazy val waDetails = tag("wa-details")
    lazy val waDropdown = tag("wa-dropdown")
    lazy val waDropdownItem = tag("wa-dropdown-item")
    lazy val waSplitPanel = tag("wa-split-panel")
    lazy val waTab = tag("wa-tab")
    lazy val waTabGroup = tag("wa-tab-group")
    lazy val waTabPanel = tag("wa-tab-panel")
    lazy val waTree = tag("wa-tree")
    lazy val waTreeItem = tag("wa-tree-item")

    // Imagery
    lazy val waIcon = tag("wa-icon")
    lazy val waAvatar = tag("wa-avatar")
    lazy val waAnimatedImage = tag("wa-animated-image")

    // Animation
    lazy val waAnimation = tag("wa-animation")

    // Notifications
    lazy val waCallout = tag("wa-callout")
    lazy val waPopover = tag("wa-popover")
    lazy val waPopup = tag("wa-popup")
    lazy val waTooltip = tag("wa-tooltip")

    // Progress
    lazy val waProgressBar = tag("wa-progress-bar")
    lazy val waProgressRing = tag("wa-progress-ring")
    lazy val waRating = tag("wa-rating")

    // Carousel
    lazy val waCarousel = tag("wa-carousel")
    lazy val waCarouselItem = tag("wa-carousel-item")

    // Comparison
    lazy val waComparison = tag("wa-comparison")

    // Formatters
    lazy val waFormatBytes = tag("wa-format-bytes")
    lazy val waFormatDate = tag("wa-format-date")
    lazy val waFormatNumber = tag("wa-format-number")
    lazy val waRelativeTime = tag("wa-relative-time")

    // Include
    lazy val waInclude = tag("wa-include")

    // QR Code
    lazy val waQrCode = tag("wa-qr-code")

    // Zoomable Frame
    lazy val waZoomableFrame = tag("wa-zoomable-frame")

    // Intersection Observer
    lazy val waIntersectionObserver = tag("wa-intersection-observer")

    // Mutation Observer
    lazy val waMutationObserver = tag("wa-mutation-observer")

    // Resize Observer
    lazy val waResizeObserver = tag("wa-resize-observer")

    // Scroller
    lazy val waScroller = tag("wa-scroller")

    // Page (Pro)
    lazy val waPage = tag("wa-page")

    // Sparkline
    lazy val waSparkline = tag("wa-sparkline")
end WebAwesomeTags
