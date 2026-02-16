// PURPOSE: JS (JsDom backend) Web Awesome bindings for Scalatags.
// PURPOSE: Provides concrete tag and attr definitions for client-side DOM rendering.
package works.iterative.scalatags.webawesome

object WebAwesome extends Attrs:
  import scalatags.JsDom.all.{tag => htmlTag}

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

  // Imagery
  lazy val waIcon = htmlTag("wa-icon")
  lazy val waAvatar = htmlTag("wa-avatar")

  // Notifications
  lazy val waCallout = htmlTag("wa-callout")

  // Progress
  lazy val waProgressBar = htmlTag("wa-progress-bar")
  lazy val waProgressRing = htmlTag("wa-progress-ring")
  lazy val waRating = htmlTag("wa-rating")
