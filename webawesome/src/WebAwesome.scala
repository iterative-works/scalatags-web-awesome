// PURPOSE: Shared attribute definitions for Web Awesome components.
// PURPOSE: Only defines attrs specific to Web Awesome, not standard HTML attrs.
package works.iterative.scalatags.webawesome

import scalatags.generic

/** Web Awesome-specific attributes.
  *
  * Standard HTML attributes (disabled, name, value, placeholder, etc.) are
  * already provided by scalatags and should be used directly from there.
  */
trait Attrs:
  // Web Components standard
  lazy val slot: generic.Attr = generic.Attr("slot")

  // Visual style
  lazy val appearance: generic.Attr = generic.Attr("appearance")
  lazy val variant: generic.Attr = generic.Attr("variant")
  lazy val pill: generic.Attr = generic.Attr("pill")
  lazy val loading: generic.Attr = generic.Attr("loading")
  lazy val withCaret: generic.Attr = generic.Attr("with-caret")

  // Dialog / Drawer
  lazy val open: generic.Attr = generic.Attr("open")
  lazy val lightDismiss: generic.Attr = generic.Attr("light-dismiss")
  lazy val withoutHeader: generic.Attr = generic.Attr("without-header")

  // Input
  lazy val hint: generic.Attr = generic.Attr("hint")
  lazy val withClear: generic.Attr = generic.Attr("with-clear")
  lazy val passwordToggle: generic.Attr = generic.Attr("password-toggle")
  lazy val passwordVisible: generic.Attr = generic.Attr("password-visible")
  lazy val indeterminate: generic.Attr = generic.Attr("indeterminate")
  lazy val withoutSpinButtons: generic.Attr = generic.Attr("without-spin-buttons")
  lazy val withoutSteppers: generic.Attr = generic.Attr("without-steppers")
  lazy val withLabel: generic.Attr = generic.Attr("with-label")
  lazy val withHint: generic.Attr = generic.Attr("with-hint")
  lazy val clearable: generic.Attr = generic.Attr("clearable")
  lazy val maxOptionsVisible: generic.Attr = generic.Attr("max-options-visible")
  lazy val allowCustomValue: generic.Attr = generic.Attr("allow-custom-value")

  // Color picker
  lazy val format: generic.Attr = generic.Attr("format")
  lazy val withoutFormatToggle: generic.Attr = generic.Attr("without-format-toggle")
  lazy val opacity: generic.Attr = generic.Attr("opacity")
  lazy val uppercase: generic.Attr = generic.Attr("uppercase")
  lazy val swatches: generic.Attr = generic.Attr("swatches")

  // Slider
  lazy val tooltip: generic.Attr = generic.Attr("tooltip")

  // Copy button
  lazy val from: generic.Attr = generic.Attr("from")
  lazy val copyLabel: generic.Attr = generic.Attr("copy-label")
  lazy val successLabel: generic.Attr = generic.Attr("success-label")
  lazy val errorLabel: generic.Attr = generic.Attr("error-label")
  lazy val feedbackDuration: generic.Attr = generic.Attr("feedback-duration")
  lazy val tooltipPlacement: generic.Attr = generic.Attr("tooltip-placement")

  // Layout / orientation
  lazy val orientation: generic.Attr = generic.Attr("orientation")
  lazy val primary: generic.Attr = generic.Attr("primary")

  // Dropdown / Popup
  lazy val anchor: generic.Attr = generic.Attr("anchor")
  lazy val active: generic.Attr = generic.Attr("active")
  lazy val placement: generic.Attr = generic.Attr("placement")
  lazy val boundary: generic.Attr = generic.Attr("boundary")
  lazy val distance: generic.Attr = generic.Attr("distance")
  lazy val skidding: generic.Attr = generic.Attr("skidding")
  lazy val arrow: generic.Attr = generic.Attr("arrow")
  lazy val arrowPlacement: generic.Attr = generic.Attr("arrow-placement")
  lazy val arrowPadding: generic.Attr = generic.Attr("arrow-padding")
  lazy val flipFallbackPlacements: generic.Attr = generic.Attr("flip-fallback-placements")
  lazy val flipFallbackStrategy: generic.Attr = generic.Attr("flip-fallback-strategy")
  lazy val flipPadding: generic.Attr = generic.Attr("flip-padding")
  lazy val shift: generic.Attr = generic.Attr("shift")
  lazy val shiftPadding: generic.Attr = generic.Attr("shift-padding")
  lazy val autoSize: generic.Attr = generic.Attr("auto-size")
  lazy val sync: generic.Attr = generic.Attr("sync")
  lazy val autoSizePadding: generic.Attr = generic.Attr("auto-size-padding")
  lazy val hoverBridge: generic.Attr = generic.Attr("hover-bridge")
  lazy val submenuOpen: generic.Attr = generic.Attr("submenu-open")
  lazy val withoutArrow: generic.Attr = generic.Attr("without-arrow")
  lazy val trigger: generic.Attr = generic.Attr("trigger")
  lazy val hoist: generic.Attr = generic.Attr("hoist")

  // Avatar
  lazy val image: generic.Attr = generic.Attr("image")
  lazy val initials: generic.Attr = generic.Attr("initials")
  lazy val shape: generic.Attr = generic.Attr("shape")

  // Badge
  lazy val attention: generic.Attr = generic.Attr("attention")

  // Icon
  lazy val family: generic.Attr = generic.Attr("family")
  lazy val autoWidth: generic.Attr = generic.Attr("auto-width")
  lazy val swapOpacity: generic.Attr = generic.Attr("swap-opacity")
  lazy val library: generic.Attr = generic.Attr("library")
  lazy val rotate: generic.Attr = generic.Attr("rotate")
  lazy val flip: generic.Attr = generic.Attr("flip")
  lazy val animation: generic.Attr = generic.Attr("animation")

  // Skeleton
  lazy val effect: generic.Attr = generic.Attr("effect")

  // Tag
  lazy val withRemove: generic.Attr = generic.Attr("with-remove")

  // Card
  lazy val withHeader: generic.Attr = generic.Attr("with-header")
  lazy val withMedia: generic.Attr = generic.Attr("with-media")
  lazy val withFooter: generic.Attr = generic.Attr("with-footer")

  // Details
  lazy val summary: generic.Attr = generic.Attr("summary")
  lazy val iconPlacement: generic.Attr = generic.Attr("icon-placement")

  // Tab
  lazy val panel: generic.Attr = generic.Attr("panel")
  lazy val activation: generic.Attr = generic.Attr("activation")
  lazy val withoutScrollControls: generic.Attr = generic.Attr("without-scroll-controls")

  // Tree
  lazy val selection: generic.Attr = generic.Attr("selection")
  lazy val `lazy`: generic.Attr = generic.Attr("lazy")
  lazy val expanded: generic.Attr = generic.Attr("expanded")

  // Animated Image
  lazy val play: generic.Attr = generic.Attr("play")

  // Animation
  lazy val delay: generic.Attr = generic.Attr("delay")
  lazy val duration: generic.Attr = generic.Attr("duration")
  lazy val easing: generic.Attr = generic.Attr("easing")
  lazy val endDelay: generic.Attr = generic.Attr("end-delay")
  lazy val fill: generic.Attr = generic.Attr("fill")
  lazy val iterations: generic.Attr = generic.Attr("iterations")
  lazy val iterationStart: generic.Attr = generic.Attr("iteration-start")
  lazy val playbackRate: generic.Attr = generic.Attr("playback-rate")
  lazy val keyframes: generic.Attr = generic.Attr("keyframes")

  // Carousel
  lazy val loop: generic.Attr = generic.Attr("loop")
  lazy val navigation: generic.Attr = generic.Attr("navigation")
  lazy val pagination: generic.Attr = generic.Attr("pagination")
  lazy val autoplay: generic.Attr = generic.Attr("autoplay")
  lazy val autoplayInterval: generic.Attr = generic.Attr("autoplay-interval")
  lazy val slidesPerPage: generic.Attr = generic.Attr("slides-per-page")
  lazy val slidesPerMove: generic.Attr = generic.Attr("slides-per-move")
  lazy val mouseDragging: generic.Attr = generic.Attr("mouse-dragging")

  // Formatters
  lazy val unit: generic.Attr = generic.Attr("unit")
  lazy val date: generic.Attr = generic.Attr("date")
  lazy val weekday: generic.Attr = generic.Attr("weekday")
  lazy val era: generic.Attr = generic.Attr("era")
  lazy val year: generic.Attr = generic.Attr("year")
  lazy val month: generic.Attr = generic.Attr("month")
  lazy val day: generic.Attr = generic.Attr("day")
  lazy val hour: generic.Attr = generic.Attr("hour")
  lazy val minute: generic.Attr = generic.Attr("minute")
  lazy val second: generic.Attr = generic.Attr("second")
  lazy val timeZoneName: generic.Attr = generic.Attr("time-zone-name")
  lazy val timeZone: generic.Attr = generic.Attr("time-zone")
  lazy val hourFormat: generic.Attr = generic.Attr("hour-format")
  lazy val withoutGrouping: generic.Attr = generic.Attr("without-grouping")
  lazy val currency: generic.Attr = generic.Attr("currency")
  lazy val currencyDisplay: generic.Attr = generic.Attr("currency-display")
  lazy val minimumIntegerDigits: generic.Attr = generic.Attr("minimum-integer-digits")
  lazy val minimumFractionDigits: generic.Attr = generic.Attr("minimum-fraction-digits")
  lazy val maximumFractionDigits: generic.Attr = generic.Attr("maximum-fraction-digits")
  lazy val minimumSignificantDigits: generic.Attr = generic.Attr("minimum-significant-digits")
  lazy val maximumSignificantDigits: generic.Attr = generic.Attr("maximum-significant-digits")
  lazy val numeric: generic.Attr = generic.Attr("numeric")

  // Include
  lazy val mode: generic.Attr = generic.Attr("mode")
  lazy val allowScripts: generic.Attr = generic.Attr("allow-scripts")

  // QR Code
  lazy val radius: generic.Attr = generic.Attr("radius")
  lazy val errorCorrection: generic.Attr = generic.Attr("error-correction")

  // Zoomable Frame
  lazy val zoom: generic.Attr = generic.Attr("zoom")
  lazy val zoomLevels: generic.Attr = generic.Attr("zoom-levels")
  lazy val withoutControls: generic.Attr = generic.Attr("without-controls")
  lazy val withoutInteraction: generic.Attr = generic.Attr("without-interaction")

  // Intersection Observer
  lazy val root: generic.Attr = generic.Attr("root")
  lazy val rootMargin: generic.Attr = generic.Attr("root-margin")
  lazy val threshold: generic.Attr = generic.Attr("threshold")
  lazy val intersectClass: generic.Attr = generic.Attr("intersect-class")
  lazy val once: generic.Attr = generic.Attr("once")

  // Mutation Observer
  lazy val attrOldValue: generic.Attr = generic.Attr("attr-old-value")
  lazy val charData: generic.Attr = generic.Attr("char-data")
  lazy val charDataOldValue: generic.Attr = generic.Attr("char-data-old-value")
  lazy val childList: generic.Attr = generic.Attr("child-list")

  // Page
  lazy val view: generic.Attr = generic.Attr("view")
  lazy val navOpen: generic.Attr = generic.Attr("nav-open")
  lazy val mobileBreakpoint: generic.Attr = generic.Attr("mobile-breakpoint")
  lazy val navigationPlacement: generic.Attr = generic.Attr("navigation-placement")
  lazy val disableNavigationToggle: generic.Attr = generic.Attr("disable-navigation-toggle")
