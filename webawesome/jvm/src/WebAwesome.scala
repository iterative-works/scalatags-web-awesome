// PURPOSE: JVM (Text backend) Web Awesome bindings for Scalatags.
// PURPOSE: Provides concrete tag and attr definitions for server-side HTML rendering.
package works.iterative.scalatags.webawesome

object WebAwesome extends Attrs:
  import scalatags.Text.all.{tag => htmlTag}

  // Actions
  lazy val waButton = htmlTag("wa-button")
  lazy val waButtonGroup = htmlTag("wa-button-group")
  lazy val waCopyButton = htmlTag("wa-copy-button")

  // Feedback
  lazy val waBadge = htmlTag("wa-badge")
  lazy val waSpinner = htmlTag("wa-spinner")
  lazy val waSkeleton = htmlTag("wa-skeleton")
  lazy val waTag = htmlTag("wa-tag")

  // Form controls
  lazy val waInput = htmlTag("wa-input")
  lazy val waSwitch = htmlTag("wa-switch")
  lazy val waCheckbox = htmlTag("wa-checkbox")
  lazy val waSelect = htmlTag("wa-select")
  lazy val waOption = htmlTag("wa-option")
  lazy val waRadio = htmlTag("wa-radio")
  lazy val waRadioGroup = htmlTag("wa-radio-group")
  lazy val waColorPicker = htmlTag("wa-color-picker")
  lazy val waNumberInput = htmlTag("wa-number-input")
  lazy val waSlider = htmlTag("wa-slider")
  lazy val waTextarea = htmlTag("wa-textarea")

  // Organization
  lazy val waBreadcrumb = htmlTag("wa-breadcrumb")
  lazy val waBreadcrumbItem = htmlTag("wa-breadcrumb-item")
  lazy val waCard = htmlTag("wa-card")
  lazy val waDialog = htmlTag("wa-dialog")
  lazy val waDrawer = htmlTag("wa-drawer")
  lazy val waDivider = htmlTag("wa-divider")
  lazy val waDetails = htmlTag("wa-details")
  lazy val waDropdown = htmlTag("wa-dropdown")
  lazy val waDropdownItem = htmlTag("wa-dropdown-item")
  lazy val waSplitPanel = htmlTag("wa-split-panel")
  lazy val waTab = htmlTag("wa-tab")
  lazy val waTabGroup = htmlTag("wa-tab-group")
  lazy val waTabPanel = htmlTag("wa-tab-panel")
  lazy val waTree = htmlTag("wa-tree")
  lazy val waTreeItem = htmlTag("wa-tree-item")

  // Imagery
  lazy val waIcon = htmlTag("wa-icon")
  lazy val waAvatar = htmlTag("wa-avatar")
  lazy val waAnimatedImage = htmlTag("wa-animated-image")

  // Animation
  lazy val waAnimation = htmlTag("wa-animation")

  // Notifications
  lazy val waCallout = htmlTag("wa-callout")
  lazy val waPopover = htmlTag("wa-popover")
  lazy val waPopup = htmlTag("wa-popup")
  lazy val waTooltip = htmlTag("wa-tooltip")

  // Progress
  lazy val waProgressBar = htmlTag("wa-progress-bar")
  lazy val waProgressRing = htmlTag("wa-progress-ring")
  lazy val waRating = htmlTag("wa-rating")

  // Carousel
  lazy val waCarousel = htmlTag("wa-carousel")
  lazy val waCarouselItem = htmlTag("wa-carousel-item")

  // Comparison
  lazy val waComparison = htmlTag("wa-comparison")

  // Formatters
  lazy val waFormatBytes = htmlTag("wa-format-bytes")
  lazy val waFormatDate = htmlTag("wa-format-date")
  lazy val waFormatNumber = htmlTag("wa-format-number")
  lazy val waRelativeTime = htmlTag("wa-relative-time")

  // Include
  lazy val waInclude = htmlTag("wa-include")

  // QR Code
  lazy val waQrCode = htmlTag("wa-qr-code")

  // Zoomable Frame
  lazy val waZoomableFrame = htmlTag("wa-zoomable-frame")

  // Intersection Observer
  lazy val waIntersectionObserver = htmlTag("wa-intersection-observer")
