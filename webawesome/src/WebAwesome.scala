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
