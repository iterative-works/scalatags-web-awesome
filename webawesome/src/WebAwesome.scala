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
