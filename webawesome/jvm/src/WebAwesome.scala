// PURPOSE: JVM (Text backend) Web Awesome bindings for Scalatags.
// PURPOSE: Provides concrete tag and attr definitions for server-side HTML rendering.
package works.iterative.scalatags.webawesome

object WebAwesome extends Attrs:
  import scalatags.Text.all.{tag => htmlTag}

  // Actions
  lazy val waButton = htmlTag("wa-button")
  lazy val waButtonGroup = htmlTag("wa-button-group")

  // Feedback
  lazy val waBadge = htmlTag("wa-badge")
  lazy val waSpinner = htmlTag("wa-spinner")
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

  // Organization
  lazy val waCard = htmlTag("wa-card")
  lazy val waDialog = htmlTag("wa-dialog")
  lazy val waDivider = htmlTag("wa-divider")
  lazy val waDetails = htmlTag("wa-details")

  // Imagery
  lazy val waIcon = htmlTag("wa-icon")
  lazy val waAvatar = htmlTag("wa-avatar")
