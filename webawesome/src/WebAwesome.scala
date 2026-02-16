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

  // Layout / orientation
  lazy val orientation: generic.Attr = generic.Attr("orientation")
