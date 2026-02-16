// PURPOSE: Cask HTTP server for visually testing Web Awesome components.
// PURPOSE: Serves scenario pages with a sidebar navigation layout.
package works.iterative.scalatags.webawesome.scenarios

import scalatags.Text.all._
import works.iterative.scalatags.webawesome.WebAwesome._

object Server extends cask.MainRoutes:

  override def port: Int = 8086

  private def htmlPage(title: String, active: String)(content: Frag*): cask.Response[String] =
    cask.Response(
      Layout.page(title, active)(content*),
      headers = Seq("Content-Type" -> "text/html")
    )

  @cask.get("/")
  def index(): cask.Response[String] = htmlPage("Home", "")(
    h1("Web Awesome Scenarios"),
    p("Select a component from the sidebar to see it in action.")
  )

  // --- Button ---
  @cask.get("/button")
  def buttonPage(): cask.Response[String] = htmlPage("Button", "button")(
    h1("wa-button"),

    div(cls := "demo-section")(
      h2("Variants"),
      div(cls := "demo-row")(
        waButton(variant := "neutral")("Neutral"),
        waButton(variant := "brand")("Brand"),
        waButton(variant := "success")("Success"),
        waButton(variant := "warning")("Warning"),
        waButton(variant := "danger")("Danger")
      )
    ),

    div(cls := "demo-section")(
      h2("Appearances"),
      div(cls := "demo-row")(
        waButton(appearance := "accent")("Accent"),
        waButton(appearance := "filled")("Filled"),
        waButton(appearance := "outlined")("Outlined"),
        waButton(appearance := "plain")("Plain")
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waButton(attr("size") := "small")("Small"),
        waButton(attr("size") := "medium")("Medium"),
        waButton(attr("size") := "large")("Large")
      )
    ),

    div(cls := "demo-section")(
      h2("Pill & Loading"),
      div(cls := "demo-row")(
        waButton(pill := "true", variant := "brand")("Pill"),
        waButton(loading := "true", variant := "brand")("Loading"),
        waButton(disabled := "true")("Disabled")
      )
    )
  )

  // --- Button Group ---
  @cask.get("/button-group")
  def buttonGroupPage(): cask.Response[String] = htmlPage("Button Group", "button-group")(
    h1("wa-button-group"),

    div(cls := "demo-section")(
      h2("Horizontal (default)"),
      div(cls := "demo-row")(
        waButtonGroup(
          waButton("Left"),
          waButton("Center"),
          waButton("Right")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Vertical orientation"),
      div(cls := "demo-row")(
        waButtonGroup(orientation := "vertical")(
          waButton("Top"),
          waButton("Middle"),
          waButton("Bottom")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With variants"),
      div(cls := "demo-row")(
        waButtonGroup(
          waButton(variant := "brand")("Save"),
          waButton(variant := "neutral")("Cancel"),
          waButton(variant := "danger")("Delete")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Different appearances"),
      div(cls := "demo-row")(
        waButtonGroup(
          waButton(appearance := "accent", variant := "brand")("Accent"),
          waButton(appearance := "filled", variant := "brand")("Filled"),
          waButton(appearance := "outlined", variant := "brand")("Outlined"),
          waButton(appearance := "plain", variant := "brand")("Plain")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waButtonGroup(
          waButton(attr("size") := "small")("Small"),
          waButton(attr("size") := "small")("Group")
        ),
        waButtonGroup(
          waButton(attr("size") := "medium")("Medium"),
          waButton(attr("size") := "medium")("Group")
        ),
        waButtonGroup(
          waButton(attr("size") := "large")("Large"),
          waButton(attr("size") := "large")("Group")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Toolbar example"),
      div(cls := "demo-row")(
        waButtonGroup(
          waButton(appearance := "outlined")("Bold"),
          waButton(appearance := "outlined")("Italic"),
          waButton(appearance := "outlined")("Underline")
        ),
        waButtonGroup(
          waButton(appearance := "outlined")("Align Left"),
          waButton(appearance := "outlined")("Align Center"),
          waButton(appearance := "outlined")("Align Right")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With disabled buttons"),
      div(cls := "demo-row")(
        waButtonGroup(
          waButton(variant := "brand")("Active"),
          waButton(disabled := "true")("Disabled"),
          waButton(variant := "brand")("Active")
        )
      )
    )
  )

  // --- Copy Button ---
  @cask.get("/copy-button")
  def copyButtonPage(): cask.Response[String] = htmlPage("Copy Button", "copy-button")(
    h1("wa-copy-button"),

    div(cls := "demo-section")(
      h2("Basic"),
      div(cls := "demo-row")(
        waCopyButton(value := "Hello, World!")
      )
    ),

    div(cls := "demo-section")(
      h2("From attribute (copy from element)"),
      div(cls := "demo-row")(
        p(id := "source-text")("This text will be copied"),
        waCopyButton(from := "source-text")
      )
    ),

    div(cls := "demo-section")(
      h2("Custom labels"),
      div(cls := "demo-row")(
        waCopyButton(
          value := "Sample code here",
          copyLabel := "Copy Code",
          successLabel := "Copied!",
          errorLabel := "Failed to copy"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Feedback duration"),
      div(cls := "demo-row")(
        waCopyButton(
          value := "Quick feedback",
          feedbackDuration := "500",
          successLabel := "Done!"
        ),
        waCopyButton(
          value := "Long feedback",
          feedbackDuration := "3000",
          successLabel := "Copied to clipboard"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Tooltip placement"),
      div(cls := "demo-row")(
        waCopyButton(value := "Top placement", tooltipPlacement := "top"),
        waCopyButton(value := "Bottom placement", tooltipPlacement := "bottom"),
        waCopyButton(value := "Left placement", tooltipPlacement := "left"),
        waCopyButton(value := "Right placement", tooltipPlacement := "right")
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waCopyButton(value := "Small text", attr("size") := "small"),
        waCopyButton(value := "Medium text", attr("size") := "medium"),
        waCopyButton(value := "Large text", attr("size") := "large")
      )
    ),

    div(cls := "demo-section")(
      h2("Variants"),
      div(cls := "demo-row")(
        waCopyButton(value := "Neutral", variant := "neutral"),
        waCopyButton(value := "Brand", variant := "brand"),
        waCopyButton(value := "Success", variant := "success")
      )
    ),

    div(cls := "demo-section")(
      h2("Copy code snippet example"),
      div(attr("style") := "background: #f5f5f5; padding: 1rem; border-radius: 4px; position: relative")(
        tag("pre")(id := "code-example")(
          tag("code")(
            "const greeting = 'Hello, Web Awesome!';\n",
            "console.log(greeting);"
          )
        ),
        waCopyButton(
          from := "code-example",
          attr("style") := "position: absolute; top: 0.5rem; right: 0.5rem",
          copyLabel := "Copy",
          successLabel := "Copied!"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Disabled"),
      div(cls := "demo-row")(
        waCopyButton(value := "Cannot copy this", disabled := "true")
      )
    )
  )

  // --- Input ---
  @cask.get("/input")
  def inputPage(): cask.Response[String] = htmlPage("Input", "input")(
    h1("wa-input"),

    div(cls := "demo-section")(
      h2("Basic"),
      div(cls := "demo-row")(
        waInput(attr("label") := "Name", placeholder := "Enter your name")
      ),
      div(cls := "demo-row")(
        waInput(attr("label") := "Email", `type` := "email", placeholder := "user@example.com")
      ),
      div(cls := "demo-row")(
        waInput(attr("label") := "Password", `type` := "password", passwordToggle := "true")
      )
    ),

    div(cls := "demo-section")(
      h2("Appearances"),
      div(cls := "demo-row")(
        waInput(appearance := "outlined", placeholder := "Outlined")
      ),
      div(cls := "demo-row")(
        waInput(appearance := "filled", placeholder := "Filled")
      )
    ),

    div(cls := "demo-section")(
      h2("With label & hint (SSR)"),
      div(cls := "demo-row")(
        waInput(
          withLabel := "true",
          withHint := "true",
          attr("label") := "Username",
          hint := "Choose a unique username",
          withClear := "true",
          placeholder := "johndoe"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Number input without spin buttons"),
      div(cls := "demo-row")(
        waInput(
          `type` := "number",
          attr("label") := "Quantity",
          withoutSpinButtons := "true",
          placeholder := "Enter quantity"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waInput(attr("size") := "small", placeholder := "Small"),
        waInput(attr("size") := "medium", placeholder := "Medium"),
        waInput(attr("size") := "large", placeholder := "Large")
      )
    )
  )

  // --- Badge ---
  @cask.get("/badge")
  def badgePage(): cask.Response[String] = htmlPage("Badge", "badge")(
    h1("wa-badge"),

    div(cls := "demo-section")(
      h2("Variants"),
      div(cls := "demo-row")(
        waBadge(variant := "neutral")("Neutral"),
        waBadge(variant := "brand")("Brand"),
        waBadge(variant := "success")("Success"),
        waBadge(variant := "warning")("Warning"),
        waBadge(variant := "danger")("Danger")
      )
    ),

    div(cls := "demo-section")(
      h2("Pill"),
      div(cls := "demo-row")(
        waBadge(variant := "brand", pill := "true")("12"),
        waBadge(variant := "success", pill := "true")("New"),
        waBadge(variant := "danger", pill := "true")("99+")
      )
    ),

    div(cls := "demo-section")(
      h2("With attention animation"),
      div(cls := "demo-row")(
        waBadge(variant := "brand", attention := "pulse")("Pulse"),
        waBadge(variant := "danger", attention := "pulse")("Alert"),
        waBadge(variant := "success", attention := "pulse", pill := "true")("3")
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waBadge(variant := "brand", attr("size") := "small")("Small"),
        waBadge(variant := "brand", attr("size") := "medium")("Medium"),
        waBadge(variant := "brand", attr("size") := "large")("Large")
      )
    ),

    div(cls := "demo-section")(
      h2("Notification examples"),
      div(cls := "demo-row")(
        div(attr("style") := "position: relative; display: inline-block")(
          waButton(variant := "neutral")("Messages"),
          waBadge(
            variant := "danger",
            pill := "true",
            attention := "pulse",
            attr("style") := "position: absolute; top: -0.5rem; right: -0.5rem"
          )("5")
        ),
        div(attr("style") := "position: relative; display: inline-block")(
          waButton(variant := "neutral")("Notifications"),
          waBadge(
            variant := "brand",
            pill := "true",
            attr("style") := "position: absolute; top: -0.5rem; right: -0.5rem"
          )("12")
        ),
        div(attr("style") := "position: relative; display: inline-block")(
          waButton(variant := "neutral")("Cart"),
          waBadge(
            variant := "success",
            pill := "true",
            attr("style") := "position: absolute; top: -0.5rem; right: -0.5rem"
          )("3")
        )
      )
    )
  )

  // --- Card ---
  @cask.get("/card")
  def cardPage(): cask.Response[String] = htmlPage("Card", "card")(
    h1("wa-card"),

    div(cls := "demo-section")(
      h2("Basic card"),
      waCard(
        p("This is a simple card with some content.")
      )
    ),

    div(cls := "demo-section")(
      h2("Card with header and footer"),
      waCard(
        div(slot := "header")(
          strong("Card Title")
        ),
        p("Card body content goes here. You can put any HTML inside."),
        div(slot := "footer")(
          waButton(variant := "brand")("Action"),
          waButton(appearance := "plain")("Cancel")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Multiple cards"),
      div(cls := "demo-row")(
        waCard(attr("style") := "width: 250px")(
          div(slot := "header")(strong("First")),
          p("First card content")
        ),
        waCard(attr("style") := "width: 250px")(
          div(slot := "header")(strong("Second")),
          p("Second card content")
        ),
        waCard(attr("style") := "width: 250px")(
          div(slot := "header")(strong("Third")),
          p("Third card content")
        )
      )
    )
  )

  // --- Switch ---
  @cask.get("/switch")
  def switchPage(): cask.Response[String] = htmlPage("Switch", "switch")(
    h1("wa-switch"),

    div(cls := "demo-section")(
      h2("Basic"),
      div(cls := "demo-row")(
        waSwitch("Enable notifications"),
        waSwitch(attr("checked") := "true")("Dark mode")
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waSwitch(attr("size") := "small")("Small"),
        waSwitch(attr("size") := "medium")("Medium"),
        waSwitch(attr("size") := "large")("Large")
      )
    ),

    div(cls := "demo-section")(
      h2("Disabled"),
      div(cls := "demo-row")(
        waSwitch(disabled := "true")("Disabled off"),
        waSwitch(disabled := "true", attr("checked") := "true")("Disabled on")
      )
    )
  )

  // --- Checkbox ---
  @cask.get("/checkbox")
  def checkboxPage(): cask.Response[String] = htmlPage("Checkbox", "checkbox")(
    h1("wa-checkbox"),

    div(cls := "demo-section")(
      h2("Basic"),
      div(cls := "demo-row")(
        waCheckbox("Unchecked"),
        waCheckbox(attr("checked") := "true")("Checked")
      )
    ),

    div(cls := "demo-section")(
      h2("Indeterminate"),
      div(cls := "demo-row")(
        waCheckbox(indeterminate := "true")("Indeterminate state"),
        waCheckbox(indeterminate := "true", attr("checked") := "true")("Indeterminate + Checked")
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waCheckbox(attr("size") := "small")("Small"),
        waCheckbox(attr("size") := "medium")("Medium"),
        waCheckbox(attr("size") := "large")("Large")
      )
    ),

    div(cls := "demo-section")(
      h2("Disabled"),
      div(cls := "demo-row")(
        waCheckbox(disabled := "true")("Disabled unchecked"),
        waCheckbox(disabled := "true", attr("checked") := "true")("Disabled checked")
      )
    )
  )

  // --- Color Picker ---
  @cask.get("/color-picker")
  def colorPickerPage(): cask.Response[String] = htmlPage("Color Picker", "color-picker")(
    h1("wa-color-picker"),

    div(cls := "demo-section")(
      h2("Basic"),
      div(cls := "demo-row")(
        waColorPicker(attr("label") := "Select color"),
        waColorPicker(attr("label") := "With initial value", value := "#ff6b35")
      )
    ),

    div(cls := "demo-section")(
      h2("Formats"),
      div(cls := "demo-row")(
        waColorPicker(attr("label") := "HEX", format := "hex", value := "#4ecdc4"),
        waColorPicker(attr("label") := "RGB", format := "rgb", value := "rgb(78, 205, 196)"),
        waColorPicker(attr("label") := "HSL", format := "hsl", value := "hsl(176, 57%, 55%)")
      )
    ),

    div(cls := "demo-section")(
      h2("With opacity"),
      div(cls := "demo-row")(
        waColorPicker(attr("label") := "With opacity slider", attr("opacity") := "true", value := "#ff6b3580"),
        waColorPicker(attr("label") := "RGBA format", format := "rgb", attr("opacity") := "true", value := "rgba(255, 107, 53, 0.5)")
      )
    ),

    div(cls := "demo-section")(
      h2("Options"),
      div(cls := "demo-row")(
        waColorPicker(attr("label") := "Uppercase", uppercase := "true", value := "#95E1D3"),
        waColorPicker(attr("label") := "Without format toggle", withoutFormatToggle := "true", value := "#f38181"),
        waColorPicker(attr("label") := "Open by default", attr("open") := "true", value := "#aa96da")
      )
    ),

    div(cls := "demo-section")(
      h2("With swatches"),
      div(cls := "demo-row")(
        waColorPicker(
          attr("label") := "Preset colors",
          swatches := "#e63946; #f1faee; #a8dadc; #457b9d; #1d3557; #2a9d8f; #e76f51; #f4a261; #e9c46a; #264653"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waColorPicker(attr("size") := "small", attr("label") := "Small"),
        waColorPicker(attr("size") := "medium", attr("label") := "Medium"),
        waColorPicker(attr("size") := "large", attr("label") := "Large")
      )
    ),

    div(cls := "demo-section")(
      h2("Disabled"),
      div(cls := "demo-row")(
        waColorPicker(attr("label") := "Disabled", disabled := "true", value := "#6c757d")
      )
    )
  )

  // --- Number Input ---
  @cask.get("/number-input")
  def numberInputPage(): cask.Response[String] = htmlPage("Number Input", "number-input")(
    h1("wa-number-input"),

    div(cls := "demo-section")(
      h2("Basic"),
      div(cls := "demo-row")(
        waNumberInput(attr("label") := "Quantity", value := "1"),
        waNumberInput(attr("label") := "Price", value := "99.99", step := "0.01")
      )
    ),

    div(cls := "demo-section")(
      h2("Without steppers"),
      div(cls := "demo-row")(
        waNumberInput(attr("label") := "Amount", withoutSteppers := "true", value := "42")
      )
    ),

    div(cls := "demo-section")(
      h2("With label (SSR)"),
      div(cls := "demo-row")(
        waNumberInput(
          withLabel := "true",
          attr("label") := "Count",
          value := "10",
          min := "0",
          max := "100"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With hint (SSR)"),
      div(cls := "demo-row")(
        waNumberInput(
          withHint := "true",
          attr("label") := "Percentage",
          hint := "Enter a value between 0 and 100",
          value := "50",
          min := "0",
          max := "100"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With label and hint (SSR)"),
      div(cls := "demo-row")(
        waNumberInput(
          withLabel := "true",
          withHint := "true",
          attr("label") := "Temperature (°C)",
          hint := "Room temperature range: 18-24",
          value := "21",
          step := "0.5"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waNumberInput(attr("size") := "small", attr("label") := "Small", value := "1"),
        waNumberInput(attr("size") := "medium", attr("label") := "Medium", value := "2"),
        waNumberInput(attr("size") := "large", attr("label") := "Large", value := "3")
      )
    ),

    div(cls := "demo-section")(
      h2("Appearances"),
      div(cls := "demo-row")(
        waNumberInput(appearance := "outlined", attr("label") := "Outlined", value := "10"),
        waNumberInput(appearance := "filled", attr("label") := "Filled", value := "20")
      )
    ),

    div(cls := "demo-section")(
      h2("States"),
      div(cls := "demo-row")(
        waNumberInput(attr("label") := "Disabled", disabled := "true", value := "99"),
        waNumberInput(attr("label") := "Readonly", readonly := "true", value := "42"),
        waNumberInput(attr("label") := "Required", required := "true")
      )
    )
  )

  // --- Radio ---
  @cask.get("/radio")
  def radioPage(): cask.Response[String] = htmlPage("Radio", "radio")(
    h1("wa-radio & wa-radio-group"),

    div(cls := "demo-section")(
      h2("Basic radio group"),
      waRadioGroup(attr("label") := "Select your favorite color", name := "color-basic")(
        waRadio(value := "red")("Red"),
        waRadio(value := "green")("Green"),
        waRadio(value := "blue", attr("checked") := "true")("Blue")
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waRadioGroup(attr("label") := "Small", attr("size") := "small", name := "size-small")(
          waRadio(value := "1")("Option 1"),
          waRadio(value := "2")("Option 2")
        ),
        waRadioGroup(attr("label") := "Medium", attr("size") := "medium", name := "size-medium")(
          waRadio(value := "1")("Option 1"),
          waRadio(value := "2")("Option 2")
        ),
        waRadioGroup(attr("label") := "Large", attr("size") := "large", name := "size-large")(
          waRadio(value := "1")("Option 1"),
          waRadio(value := "2")("Option 2")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Button appearance"),
      waRadioGroup(attr("label") := "Choose size", name := "button-appearance")(
        waRadio(value := "s", appearance := "button")("Small"),
        waRadio(value := "m", appearance := "button", attr("checked") := "true")("Medium"),
        waRadio(value := "l", appearance := "button")("Large"),
        waRadio(value := "xl", appearance := "button")("X-Large")
      )
    ),

    div(cls := "demo-section")(
      h2("Disabled state"),
      waRadioGroup(attr("label") := "Disabled options", name := "disabled")(
        waRadio(value := "opt1")("Enabled option"),
        waRadio(value := "opt2", disabled := "true")("Disabled option"),
        waRadio(value := "opt3", disabled := "true", attr("checked") := "true")("Disabled & checked")
      )
    ),

    div(cls := "demo-section")(
      h2("With hint"),
      waRadioGroup(
        attr("label") := "Select payment method",
        hint := "Choose how you would like to pay",
        name := "payment"
      )(
        waRadio(value := "card")("Credit Card"),
        waRadio(value := "paypal")("PayPal"),
        waRadio(value := "bank")("Bank Transfer")
      )
    )
  )

  // --- Select ---
  @cask.get("/select")
  def selectPage(): cask.Response[String] = htmlPage("Select", "select")(
    h1("wa-select & wa-option"),

    div(cls := "demo-section")(
      h2("Basic"),
      div(cls := "demo-row")(
        waSelect(attr("label") := "Country", placeholder := "Select a country")(
          waOption(value := "us")("United States"),
          waOption(value := "uk")("United Kingdom"),
          waOption(value := "ca")("Canada"),
          waOption(value := "de")("Germany"),
          waOption(value := "fr")("France")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With selected value"),
      div(cls := "demo-row")(
        waSelect(attr("label") := "Language", value := "en")(
          waOption(value := "en")("English"),
          waOption(value := "es")("Spanish"),
          waOption(value := "fr")("French"),
          waOption(value := "de")("German")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Clearable"),
      div(cls := "demo-row")(
        waSelect(attr("label") := "Theme", clearable := "true", value := "dark")(
          waOption(value := "light")("Light"),
          waOption(value := "dark")("Dark"),
          waOption(value := "auto")("Auto")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With label (SSR)"),
      div(cls := "demo-row")(
        waSelect(
          withLabel := "true",
          attr("label") := "Priority",
          placeholder := "Choose priority"
        )(
          waOption(value := "low")("Low"),
          waOption(value := "medium")("Medium"),
          waOption(value := "high")("High")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With hint (SSR)"),
      div(cls := "demo-row")(
        waSelect(
          withHint := "true",
          attr("label") := "Status",
          hint := "Select the current status",
          placeholder := "Choose status"
        )(
          waOption(value := "draft")("Draft"),
          waOption(value := "review")("In Review"),
          waOption(value := "published")("Published")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With label and hint (SSR)"),
      div(cls := "demo-row")(
        waSelect(
          withLabel := "true",
          withHint := "true",
          attr("label") := "Department",
          hint := "Choose your department",
          placeholder := "Select department"
        )(
          waOption(value := "eng")("Engineering"),
          waOption(value := "sales")("Sales"),
          waOption(value := "marketing")("Marketing"),
          waOption(value := "support")("Support")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waSelect(attr("size") := "small", attr("label") := "Small", placeholder := "Small select")(
          waOption(value := "1")("Option 1"),
          waOption(value := "2")("Option 2")
        ),
        waSelect(attr("size") := "medium", attr("label") := "Medium", placeholder := "Medium select")(
          waOption(value := "1")("Option 1"),
          waOption(value := "2")("Option 2")
        ),
        waSelect(attr("size") := "large", attr("label") := "Large", placeholder := "Large select")(
          waOption(value := "1")("Option 1"),
          waOption(value := "2")("Option 2")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Appearances"),
      div(cls := "demo-row")(
        waSelect(appearance := "outlined", attr("label") := "Outlined", placeholder := "Outlined select")(
          waOption(value := "a")("Option A"),
          waOption(value := "b")("Option B")
        ),
        waSelect(appearance := "filled", attr("label") := "Filled", placeholder := "Filled select")(
          waOption(value := "a")("Option A"),
          waOption(value := "b")("Option B")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("States"),
      div(cls := "demo-row")(
        waSelect(attr("label") := "Disabled", disabled := "true", placeholder := "Disabled")(
          waOption(value := "1")("Option 1"),
          waOption(value := "2")("Option 2")
        ),
        waSelect(attr("label") := "Required", required := "true", placeholder := "Required field")(
          waOption(value := "1")("Option 1"),
          waOption(value := "2")("Option 2")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Multiple selection"),
      div(cls := "demo-row")(
        waSelect(
          attr("label") := "Skills",
          multiple := "true",
          placeholder := "Select multiple skills"
        )(
          waOption(value := "js")("JavaScript"),
          waOption(value := "ts")("TypeScript"),
          waOption(value := "scala")("Scala"),
          waOption(value := "python")("Python"),
          waOption(value := "rust")("Rust")
        )
      )
    )
  )

  // --- Slider ---
  @cask.get("/slider")
  def sliderPage(): cask.Response[String] = htmlPage("Slider", "slider")(
    h1("wa-slider"),

    div(cls := "demo-section")(
      h2("Basic"),
      div(cls := "demo-row")(
        waSlider(attr("label") := "Volume", value := "50", min := "0", max := "100")
      )
    ),

    div(cls := "demo-section")(
      h2("With step"),
      div(cls := "demo-row")(
        waSlider(attr("label") := "Temperature", value := "20", min := "0", max := "40", step := "5")
      )
    ),

    div(cls := "demo-section")(
      h2("With tooltip"),
      div(cls := "demo-row")(
        waSlider(attr("label") := "Brightness", value := "75", min := "0", max := "100", tooltip := "always")
      )
    ),

    div(cls := "demo-section")(
      h2("Tooltip on hover"),
      div(cls := "demo-row")(
        waSlider(attr("label") := "Opacity", value := "80", min := "0", max := "100", tooltip := "hover")
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waSlider(attr("size") := "small", attr("label") := "Small", value := "30"),
        waSlider(attr("size") := "medium", attr("label") := "Medium", value := "50"),
        waSlider(attr("size") := "large", attr("label") := "Large", value := "70")
      )
    ),

    div(cls := "demo-section")(
      h2("Disabled"),
      div(cls := "demo-row")(
        waSlider(attr("label") := "Disabled slider", value := "60", disabled := "true")
      )
    ),

    div(cls := "demo-section")(
      h2("With label (SSR)"),
      div(cls := "demo-row")(
        waSlider(
          withLabel := "true",
          attr("label") := "Progress",
          value := "45",
          min := "0",
          max := "100"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With hint (SSR)"),
      div(cls := "demo-row")(
        waSlider(
          withHint := "true",
          attr("label") := "Rating",
          hint := "Slide to rate from 0 to 10",
          value := "7",
          min := "0",
          max := "10"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With label and hint (SSR)"),
      div(cls := "demo-row")(
        waSlider(
          withLabel := "true",
          withHint := "true",
          attr("label") := "Quality",
          hint := "Select quality level (1-100)",
          value := "85",
          min := "1",
          max := "100"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Decimal values"),
      div(cls := "demo-row")(
        waSlider(
          attr("label") := "Zoom",
          value := "1.5",
          min := "0.5",
          max := "3.0",
          step := "0.1",
          tooltip := "always"
        )
      )
    )
  )

  // --- Textarea ---
  @cask.get("/textarea")
  def textareaPage(): cask.Response[String] = htmlPage("Textarea", "textarea")(
    h1("wa-textarea"),

    div(cls := "demo-section")(
      h2("Basic"),
      div(cls := "demo-row")(
        waTextarea(attr("label") := "Message", placeholder := "Enter your message"),
        waTextarea(attr("label") := "Comments", placeholder := "Type here...", value := "Some initial text")
      )
    ),

    div(cls := "demo-section")(
      h2("Appearances"),
      div(cls := "demo-row")(
        waTextarea(appearance := "outlined", attr("label") := "Outlined", placeholder := "Outlined textarea"),
        waTextarea(appearance := "filled", attr("label") := "Filled", placeholder := "Filled textarea")
      )
    ),

    div(cls := "demo-section")(
      h2("With label (SSR)"),
      div(cls := "demo-row")(
        waTextarea(
          withLabel := "true",
          attr("label") := "Feedback",
          placeholder := "Tell us what you think..."
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With hint (SSR)"),
      div(cls := "demo-row")(
        waTextarea(
          withHint := "true",
          attr("label") := "Description",
          hint := "Provide a detailed description",
          placeholder := "Enter description here"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With label and hint (SSR)"),
      div(cls := "demo-row")(
        waTextarea(
          withLabel := "true",
          withHint := "true",
          attr("label") := "Bio",
          hint := "Share a few words about yourself (max 500 characters)",
          placeholder := "Write your bio..."
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waTextarea(attr("size") := "small", attr("label") := "Small", placeholder := "Small textarea"),
        waTextarea(attr("size") := "medium", attr("label") := "Medium", placeholder := "Medium textarea"),
        waTextarea(attr("size") := "large", attr("label") := "Large", placeholder := "Large textarea")
      )
    ),

    div(cls := "demo-section")(
      h2("Rows"),
      div(cls := "demo-row")(
        waTextarea(attr("label") := "Default rows", placeholder := "Default height (3 rows)"),
        waTextarea(attr("label") := "More rows", rows := "8", placeholder := "Taller textarea with 8 rows")
      )
    ),

    div(cls := "demo-section")(
      h2("States"),
      div(cls := "demo-row")(
        waTextarea(attr("label") := "Disabled", disabled := "true", placeholder := "This is disabled"),
        waTextarea(attr("label") := "Readonly", readonly := "true", value := "This text cannot be edited"),
        waTextarea(attr("label") := "Required", required := "true", placeholder := "This field is required")
      )
    ),

    div(cls := "demo-section")(
      h2("Max length"),
      div(cls := "demo-row")(
        waTextarea(
          attr("label") := "Limited input",
          maxlength := "100",
          placeholder := "Maximum 100 characters allowed",
          value := "This textarea has a character limit."
        )
      )
    )
  )

  // --- Dropdown Item ---
  @cask.get("/dropdown-item")
  def dropdownItemPage(): cask.Response[String] = htmlPage("Dropdown Item", "dropdown-item")(
    h1("wa-dropdown-item"),

    div(cls := "demo-section")(
      h2("Basic dropdown items"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", withCaret := "true")("Basic Items"),
          waDropdownItem("Item 1"),
          waDropdownItem("Item 2"),
          waDropdownItem("Item 3")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With value attribute"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", withCaret := "true")("Select Action"),
          waDropdownItem(value := "edit")("Edit"),
          waDropdownItem(value := "copy")("Copy"),
          waDropdownItem(value := "delete")("Delete")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Checkbox type"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", withCaret := "true")("Options"),
          waDropdownItem(`type` := "checkbox", attr("checked") := "true")("Show notifications"),
          waDropdownItem(`type` := "checkbox")("Enable sounds"),
          waDropdownItem(`type` := "checkbox", attr("checked") := "true")("Auto-save")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Variants"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", withCaret := "true")("Actions"),
          waDropdownItem(variant := "default")("Save"),
          waDropdownItem(variant := "default")("Export"),
          waDivider,
          waDropdownItem(variant := "danger")("Delete")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Disabled items"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", withCaret := "true")("Edit Menu"),
          waDropdownItem("Cut"),
          waDropdownItem("Copy"),
          waDropdownItem(disabled := "true")("Paste (disabled)"),
          waDropdownItem("Select All")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With icon slot"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", withCaret := "true")("File Menu"),
          waDropdownItem(
            waIcon(slot := "icon", name := "file")(""),
            "New File"
          ),
          waDropdownItem(
            waIcon(slot := "icon", name := "folder")(""),
            "Open Folder"
          ),
          waDropdownItem(
            waIcon(slot := "icon", name := "floppy-disk")(""),
            "Save"
          )
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With details slot"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", withCaret := "true")("Recent Files"),
          waDropdownItem(
            "Document.pdf",
            tag("small")(slot := "details", attr("style") := "color: #666")("2 hours ago")
          ),
          waDropdownItem(
            "Spreadsheet.xlsx",
            tag("small")(slot := "details", attr("style") := "color: #666")("Yesterday")
          ),
          waDropdownItem(
            "Presentation.pptx",
            tag("small")(slot := "details", attr("style") := "color: #666")("3 days ago")
          )
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Submenu (nested dropdown)"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", withCaret := "true")("Main Menu"),
          waDropdownItem("Home"),
          waDropdownItem("About"),
          waDropdownItem(
            "Products",
            waDropdownItem(slot := "submenu")("Laptops"),
            waDropdownItem(slot := "submenu")("Phones"),
            waDropdownItem(slot := "submenu")("Tablets")
          ),
          waDropdownItem(
            "Services",
            waDropdownItem(slot := "submenu")("Consulting"),
            waDropdownItem(slot := "submenu")("Support"),
            waDropdownItem(slot := "submenu")("Training")
          ),
          waDropdownItem("Contact")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Submenu open by default"),
      div(cls := "demo-row")(
        waDropdown(attr("open") := "true")(
          waButton(slot := "trigger", withCaret := "true")("Categories"),
          waDropdownItem("Featured"),
          waDropdownItem(
            submenuOpen := "true"
          )(
            "Electronics",
            waDropdownItem(slot := "submenu")("Computers"),
            waDropdownItem(slot := "submenu")("Phones"),
            waDropdownItem(slot := "submenu")("Audio")
          ),
          waDropdownItem("Clothing"),
          waDropdownItem("Books")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Complex menu with icons, details, and submenus"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", variant := "brand", withCaret := "true")("User Menu"),
          waDropdownItem(
            waIcon(slot := "icon", name := "user")(""),
            "Profile",
            tag("kbd")(slot := "details", attr("style") := "font-size: 0.8rem")("⌘P")
          ),
          waDropdownItem(
            waIcon(slot := "icon", name := "gear")(""),
            "Settings",
            waDropdownItem(slot := "submenu")(
              waIcon(slot := "icon", name := "bell")(""),
              "Notifications"
            ),
            waDropdownItem(slot := "submenu")(
              waIcon(slot := "icon", name := "lock")(""),
              "Privacy"
            ),
            waDropdownItem(slot := "submenu")(
              waIcon(slot := "icon", name := "palette")(""),
              "Appearance"
            )
          ),
          waDivider,
          waDropdownItem(
            waIcon(slot := "icon", name := "circle-question")(""),
            "Help",
            tag("kbd")(slot := "details", attr("style") := "font-size: 0.8rem")("⌘H")
          ),
          waDivider,
          waDropdownItem(variant := "danger")(
            waIcon(slot := "icon", name := "arrow-right-from-bracket")(""),
            "Logout"
          )
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Checkbox items with mixed states"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", withCaret := "true")("View Options"),
          waDropdownItem(`type` := "checkbox", attr("checked") := "true")("Show Toolbar"),
          waDropdownItem(`type` := "checkbox", attr("checked") := "true")("Show Sidebar"),
          waDropdownItem(`type` := "checkbox")("Show Footer"),
          waDivider,
          waDropdownItem(`type` := "checkbox", attr("checked") := "true")("Line Numbers"),
          waDropdownItem(`type` := "checkbox")("Word Wrap"),
          waDropdownItem(`type` := "checkbox", disabled := "true")("Minimap (Pro only)")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Multi-level submenu"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", withCaret := "true")("Navigation"),
          waDropdownItem("Dashboard"),
          waDropdownItem(
            "Content",
            waDropdownItem(slot := "submenu")("Posts"),
            waDropdownItem(slot := "submenu")(
              "Media",
              waDropdownItem(slot := "submenu")("Images"),
              waDropdownItem(slot := "submenu")("Videos"),
              waDropdownItem(slot := "submenu")("Documents")
            ),
            waDropdownItem(slot := "submenu")("Pages")
          ),
          waDropdownItem(
            "Users",
            waDropdownItem(slot := "submenu")("All Users"),
            waDropdownItem(slot := "submenu")("Add New"),
            waDropdownItem(slot := "submenu")("Roles")
          ),
          waDropdownItem("Settings")
        )
      )
    )
  )

  // --- Dropdown ---
  @cask.get("/dropdown")
  def dropdownPage(): cask.Response[String] = htmlPage("Dropdown", "dropdown")(
    h1("wa-dropdown"),

    div(cls := "demo-section")(
      h2("Basic dropdown"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", withCaret := "true")("Dropdown"),
          waDropdownItem("Option 1"),
          waDropdownItem("Option 2"),
          waDropdownItem("Option 3")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Open by default"),
      div(cls := "demo-row")(
        waDropdown(attr("open") := "true")(
          waButton(slot := "trigger", withCaret := "true")("Always Open"),
          waDropdownItem("Item A"),
          waDropdownItem("Item B"),
          waDropdownItem("Item C")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Placement options"),
      div(cls := "demo-row")(
        waDropdown(placement := "top")(
          waButton(slot := "trigger", withCaret := "true")("Top"),
          waDropdownItem("Above the trigger"),
          waDropdownItem("Second item"),
          waDropdownItem("Third item")
        ),
        waDropdown(placement := "bottom")(
          waButton(slot := "trigger", withCaret := "true")("Bottom (default)"),
          waDropdownItem("Below the trigger"),
          waDropdownItem("Second item")
        ),
        waDropdown(placement := "left")(
          waButton(slot := "trigger", withCaret := "true")("Left"),
          waDropdownItem("To the left"),
          waDropdownItem("Second item")
        ),
        waDropdown(placement := "right")(
          waButton(slot := "trigger", withCaret := "true")("Right"),
          waDropdownItem("To the right"),
          waDropdownItem("Second item")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Placement with alignment"),
      div(cls := "demo-row")(
        waDropdown(placement := "bottom-start")(
          waButton(slot := "trigger", withCaret := "true")("Bottom Start"),
          waDropdownItem("Aligned to start"),
          waDropdownItem("Second item")
        ),
        waDropdown(placement := "bottom-end")(
          waButton(slot := "trigger", withCaret := "true")("Bottom End"),
          waDropdownItem("Aligned to end"),
          waDropdownItem("Second item")
        ),
        waDropdown(placement := "top-start")(
          waButton(slot := "trigger", withCaret := "true")("Top Start"),
          waDropdownItem("Aligned to start"),
          waDropdownItem("Second item")
        ),
        waDropdown(placement := "top-end")(
          waButton(slot := "trigger", withCaret := "true")("Top End"),
          waDropdownItem("Aligned to end"),
          waDropdownItem("Second item")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Distance from trigger"),
      div(cls := "demo-row")(
        waDropdown(distance := "0")(
          waButton(slot := "trigger", withCaret := "true")("No distance"),
          waDropdownItem("Right next to trigger"),
          waDropdownItem("Second item")
        ),
        waDropdown(distance := "8")(
          waButton(slot := "trigger", withCaret := "true")("Default (8px)"),
          waDropdownItem("Standard distance"),
          waDropdownItem("Second item")
        ),
        waDropdown(distance := "20")(
          waButton(slot := "trigger", withCaret := "true")("Far (20px)"),
          waDropdownItem("Larger gap"),
          waDropdownItem("Second item")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Skidding (offset along trigger)"),
      div(cls := "demo-row")(
        waDropdown(skidding := "-50")(
          waButton(slot := "trigger", withCaret := "true")("Skid left (-50px)"),
          waDropdownItem("Shifted left"),
          waDropdownItem("Second item")
        ),
        waDropdown(skidding := "0")(
          waButton(slot := "trigger", withCaret := "true")("No skidding"),
          waDropdownItem("Centered"),
          waDropdownItem("Second item")
        ),
        waDropdown(skidding := "50")(
          waButton(slot := "trigger", withCaret := "true")("Skid right (50px)"),
          waDropdownItem("Shifted right"),
          waDropdownItem("Second item")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Different trigger elements"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", variant := "brand", withCaret := "true")("Brand Button"),
          waDropdownItem("Action 1"),
          waDropdownItem("Action 2"),
          waDropdownItem("Action 3")
        ),
        waDropdown(
          tag("button")(slot := "trigger", attr("style") := "padding: 0.5rem 1rem; cursor: pointer")("Native Button"),
          waDropdownItem("Option A"),
          waDropdownItem("Option B")
        ),
        waDropdown(
          a(slot := "trigger", href := "#", attr("style") := "text-decoration: none")("Link trigger"),
          waDropdownItem("Menu item 1"),
          waDropdownItem("Menu item 2")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Dropdown sizes"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", attr("size") := "small", withCaret := "true")("Small"),
          waDropdownItem("Small item 1"),
          waDropdownItem("Small item 2")
        ),
        waDropdown(
          waButton(slot := "trigger", attr("size") := "medium", withCaret := "true")("Medium"),
          waDropdownItem("Medium item 1"),
          waDropdownItem("Medium item 2")
        ),
        waDropdown(
          waButton(slot := "trigger", attr("size") := "large", withCaret := "true")("Large"),
          waDropdownItem("Large item 1"),
          waDropdownItem("Large item 2")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Complex menu items"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", variant := "brand", withCaret := "true")("User Menu"),
          waDropdownItem("Profile"),
          waDropdownItem("Settings"),
          tag("wa-divider"),
          waDropdownItem("Help & Support"),
          waDropdownItem("Documentation"),
          tag("wa-divider"),
          waDropdownItem("Logout")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Disabled items"),
      div(cls := "demo-row")(
        waDropdown(
          waButton(slot := "trigger", withCaret := "true")("Actions"),
          waDropdownItem("Edit"),
          waDropdownItem("Copy"),
          waDropdownItem(disabled := "true")("Paste (disabled)"),
          waDropdownItem("Delete")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Combined: placement, distance, skidding"),
      div(cls := "demo-row")(
        waDropdown(placement := "top-end", distance := "15", skidding := "30")(
          waButton(slot := "trigger", variant := "success", withCaret := "true")("Custom Position"),
          waDropdownItem("Top-end placement"),
          waDropdownItem("15px distance"),
          waDropdownItem("30px skidding right"),
          waDropdownItem("All combined")
        )
      )
    )
  )

  // --- Avatar ---
  @cask.get("/avatar")
  def avatarPage(): cask.Response[String] = htmlPage("Avatar", "avatar")(
    h1("wa-avatar"),

    div(cls := "demo-section")(
      h2("With initials"),
      div(cls := "demo-row")(
        waAvatar(initials := "JD"),
        waAvatar(initials := "MS"),
        waAvatar(initials := "AB")
      )
    ),

    div(cls := "demo-section")(
      h2("With image"),
      div(cls := "demo-row")(
        waAvatar(image := "https://i.pravatar.cc/150?img=1"),
        waAvatar(image := "https://i.pravatar.cc/150?img=2"),
        waAvatar(image := "https://i.pravatar.cc/150?img=3")
      )
    ),

    div(cls := "demo-section")(
      h2("Shapes"),
      div(cls := "demo-row")(
        waAvatar(initials := "RD", shape := "circle"),
        waAvatar(initials := "SQ", shape := "square"),
        waAvatar(initials := "RR", shape := "rounded")
      )
    ),

    div(cls := "demo-section")(
      h2("Shapes with images"),
      div(cls := "demo-row")(
        waAvatar(image := "https://i.pravatar.cc/150?img=4", shape := "circle"),
        waAvatar(image := "https://i.pravatar.cc/150?img=5", shape := "square"),
        waAvatar(image := "https://i.pravatar.cc/150?img=6", shape := "rounded")
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waAvatar(initials := "SM", attr("size") := "small"),
        waAvatar(initials := "MD", attr("size") := "medium"),
        waAvatar(initials := "LG", attr("size") := "large")
      )
    ),

    div(cls := "demo-section")(
      h2("Different size images"),
      div(cls := "demo-row")(
        waAvatar(image := "https://i.pravatar.cc/150?img=7", attr("size") := "small"),
        waAvatar(image := "https://i.pravatar.cc/150?img=8", attr("size") := "medium"),
        waAvatar(image := "https://i.pravatar.cc/150?img=9", attr("size") := "large")
      )
    ),

    div(cls := "demo-section")(
      h2("User profiles"),
      div(cls := "demo-row")(
        div(attr("style") := "display: flex; align-items: center; gap: 0.75rem")(
          waAvatar(image := "https://i.pravatar.cc/150?img=10"),
          div(
            div(strong("John Doe")),
            div(attr("style") := "color: #666; font-size: 0.875rem")("Software Engineer")
          )
        ),
        div(attr("style") := "display: flex; align-items: center; gap: 0.75rem")(
          waAvatar(initials := "AM", shape := "square"),
          div(
            div(strong("Alice Martin")),
            div(attr("style") := "color: #666; font-size: 0.875rem")("Product Manager")
          )
        ),
        div(attr("style") := "display: flex; align-items: center; gap: 0.75rem")(
          waAvatar(image := "https://i.pravatar.cc/150?img=11", shape := "rounded"),
          div(
            div(strong("Bob Smith")),
            div(attr("style") := "color: #666; font-size: 0.875rem")("Designer")
          )
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Avatar group"),
      div(attr("style") := "display: flex; align-items: center")(
        waAvatar(image := "https://i.pravatar.cc/150?img=12", attr("style") := "margin-right: -0.5rem"),
        waAvatar(image := "https://i.pravatar.cc/150?img=13", attr("style") := "margin-right: -0.5rem"),
        waAvatar(image := "https://i.pravatar.cc/150?img=14", attr("style") := "margin-right: -0.5rem"),
        waAvatar(initials := "+5", attr("style") := "background: #6c757d; color: white")
      )
    )
  )

  // --- Option ---
  @cask.get("/option")
  def optionPage(): cask.Response[String] = htmlPage("Option", "option")(
    h1("wa-option"),

    div(cls := "demo-section")(
      h2("Basic options"),
      div(cls := "demo-row")(
        waSelect(attr("label") := "Fruit", placeholder := "Select a fruit")(
          waOption(value := "apple")("Apple"),
          waOption(value := "banana")("Banana"),
          waOption(value := "cherry")("Cherry"),
          waOption(value := "date")("Date"),
          waOption(value := "elderberry")("Elderberry")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Disabled options"),
      div(cls := "demo-row")(
        waSelect(attr("label") := "Product", placeholder := "Select a product")(
          waOption(value := "laptop")("Laptop"),
          waOption(value := "phone")("Phone"),
          waOption(value := "tablet", disabled := "true")("Tablet (Out of stock)"),
          waOption(value := "watch")("Watch"),
          waOption(value := "headphones", disabled := "true")("Headphones (Out of stock)")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Options with different content"),
      div(cls := "demo-row")(
        waSelect(attr("label") := "City", placeholder := "Select your city", value := "nyc")(
          waOption(value := "nyc")("New York City, NY"),
          waOption(value := "la")("Los Angeles, CA"),
          waOption(value := "chicago")("Chicago, IL"),
          waOption(value := "houston")("Houston, TX"),
          waOption(value := "phoenix")("Phoenix, AZ")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Options in multiple select"),
      div(cls := "demo-row")(
        waSelect(attr("label") := "Toppings", multiple := "true", placeholder := "Choose toppings")(
          waOption(value := "pepperoni")("Pepperoni"),
          waOption(value := "mushrooms")("Mushrooms"),
          waOption(value := "onions")("Onions"),
          waOption(value := "sausage")("Sausage"),
          waOption(value := "bacon")("Bacon"),
          waOption(value := "olives")("Olives"),
          waOption(value := "peppers")("Bell Peppers"),
          waOption(value := "pineapple")("Pineapple")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Options with special characters"),
      div(cls := "demo-row")(
        waSelect(attr("label") := "Symbol", placeholder := "Select a symbol")(
          waOption(value := "alpha")("α (Alpha)"),
          waOption(value := "beta")("β (Beta)"),
          waOption(value := "gamma")("γ (Gamma)"),
          waOption(value := "delta")("δ (Delta)"),
          waOption(value := "epsilon")("ε (Epsilon)")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Many options (scrollable)"),
      div(cls := "demo-row")(
        waSelect(attr("label") := "Country", placeholder := "Select a country")(
          waOption(value := "af")("Afghanistan"),
          waOption(value := "al")("Albania"),
          waOption(value := "dz")("Algeria"),
          waOption(value := "ar")("Argentina"),
          waOption(value := "au")("Australia"),
          waOption(value := "at")("Austria"),
          waOption(value := "bd")("Bangladesh"),
          waOption(value := "be")("Belgium"),
          waOption(value := "br")("Brazil"),
          waOption(value := "ca")("Canada"),
          waOption(value := "cn")("China"),
          waOption(value := "co")("Colombia"),
          waOption(value := "cz")("Czech Republic"),
          waOption(value := "dk")("Denmark"),
          waOption(value := "eg")("Egypt"),
          waOption(value := "fi")("Finland"),
          waOption(value := "fr")("France"),
          waOption(value := "de")("Germany"),
          waOption(value := "gr")("Greece"),
          waOption(value := "in")("India"),
          waOption(value := "id")("Indonesia"),
          waOption(value := "ie")("Ireland"),
          waOption(value := "il")("Israel"),
          waOption(value := "it")("Italy"),
          waOption(value := "jp")("Japan"),
          waOption(value := "mx")("Mexico"),
          waOption(value := "nl")("Netherlands"),
          waOption(value := "nz")("New Zealand"),
          waOption(value := "no")("Norway"),
          waOption(value := "pk")("Pakistan"),
          waOption(value := "pl")("Poland"),
          waOption(value := "pt")("Portugal"),
          waOption(value := "ru")("Russia"),
          waOption(value := "sa")("Saudi Arabia"),
          waOption(value := "sg")("Singapore"),
          waOption(value := "za")("South Africa"),
          waOption(value := "kr")("South Korea"),
          waOption(value := "es")("Spain"),
          waOption(value := "se")("Sweden"),
          waOption(value := "ch")("Switzerland"),
          waOption(value := "th")("Thailand"),
          waOption(value := "tr")("Turkey"),
          waOption(value := "ua")("Ukraine"),
          waOption(value := "ae")("United Arab Emirates"),
          waOption(value := "uk")("United Kingdom"),
          waOption(value := "us")("United States"),
          waOption(value := "vn")("Vietnam")
        )
      )
    )
  )

  // --- Callout ---
  @cask.get("/callout")
  def calloutPage(): cask.Response[String] = htmlPage("Callout", "callout")(
    h1("wa-callout"),

    div(cls := "demo-section")(
      h2("Variants"),
      div(cls := "demo-row")(
        waCallout(variant := "neutral")("This is a neutral callout message."),
        waCallout(variant := "brand")("This is a brand callout message."),
        waCallout(variant := "success")("This is a success callout message."),
        waCallout(variant := "warning")("This is a warning callout message."),
        waCallout(variant := "danger")("This is a danger callout message.")
      )
    ),

    div(cls := "demo-section")(
      h2("Appearances"),
      div(cls := "demo-row")(
        waCallout(appearance := "accent", variant := "brand")("Accent appearance"),
        waCallout(appearance := "filled", variant := "brand")("Filled appearance"),
        waCallout(appearance := "outlined", variant := "brand")("Outlined appearance"),
        waCallout(appearance := "plain", variant := "brand")("Plain appearance")
      )
    ),

    div(cls := "demo-section")(
      h2("With longer content"),
      waCallout(variant := "success", appearance := "filled")(
        strong("Success! "),
        "Your changes have been saved successfully. You can now continue working or close this window."
      ),
      waCallout(variant := "warning", appearance := "outlined")(
        strong("Warning: "),
        "This action cannot be undone. Please review your changes carefully before proceeding."
      ),
      waCallout(variant := "danger", appearance := "filled")(
        strong("Error: "),
        "Something went wrong while processing your request. Please try again or contact support if the problem persists."
      )
    ),

    div(cls := "demo-section")(
      h2("Mixed variants and appearances"),
      div(cls := "demo-row")(
        waCallout(variant := "neutral", appearance := "outlined")("Neutral outlined"),
        waCallout(variant := "success", appearance := "accent")("Success accent"),
        waCallout(variant := "danger", appearance := "plain")("Danger plain")
      )
    ),

    div(cls := "demo-section")(
      h2("Information callouts"),
      waCallout(variant := "brand", appearance := "accent")(
        waIcon(slot := "icon", name := "circle-info")(""),
        strong("Pro Tip: "),
        "You can customize these callouts with different variants and appearances to match your design system."
      ),
      waCallout(variant := "neutral", appearance := "outlined")(
        waIcon(slot := "icon", name := "lightbulb")(""),
        strong("Did you know? "),
        "Web Awesome components are fully customizable and work with any CSS framework."
      )
    ),

    div(cls := "demo-section")(
      h2("Action callouts"),
      waCallout(variant := "brand", appearance := "filled")(
        strong("New feature available!"),
        p(attr("style") := "margin: 0.5rem 0")("Try our new dashboard redesign with improved analytics and reporting."),
        div(slot := "footer")(
          waButton(attr("size") := "small", appearance := "plain")("Learn More"),
          waButton(attr("size") := "small", appearance := "plain")("Dismiss")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("System messages"),
      waCallout(variant := "success", appearance := "accent")(
        waIcon(slot := "icon", name := "circle-check")(""),
        "Account verification successful"
      ),
      waCallout(variant := "warning", appearance := "filled")(
        waIcon(slot := "icon", name := "triangle-exclamation")(""),
        "Your session will expire in 5 minutes"
      ),
      waCallout(variant := "danger", appearance := "outlined")(
        waIcon(slot := "icon", name := "circle-exclamation")(""),
        "Unable to connect to server. Please check your internet connection."
      )
    )
  )

  // --- Icon ---
  @cask.get("/icon")
  def iconPage(): cask.Response[String] = htmlPage("Icon", "icon")(
    h1("wa-icon"),

    div(cls := "demo-section")(
      h2("Basic icons (classic family)"),
      div(cls := "demo-row")(
        waIcon(name := "heart")(""),
        waIcon(name := "star")(""),
        waIcon(name := "home")(""),
        waIcon(name := "user")(""),
        waIcon(name := "gear")("")
      )
    ),

    div(cls := "demo-section")(
      h2("Icon families"),
      div(cls := "demo-row")(
        waIcon(name := "heart", family := "classic")(""),
        waIcon(name := "heart", family := "sharp")(""),
        waIcon(name := "heart", family := "duotone")("")
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes (using CSS)"),
      div(cls := "demo-row")(
        waIcon(name := "star", attr("style") := "font-size: 1rem")(""),
        waIcon(name := "star", attr("style") := "font-size: 1.5rem")(""),
        waIcon(name := "star", attr("style") := "font-size: 2rem")(""),
        waIcon(name := "star", attr("style") := "font-size: 3rem")(""),
        waIcon(name := "star", attr("style") := "font-size: 4rem")("")
      )
    ),

    div(cls := "demo-section")(
      h2("Rotation"),
      div(cls := "demo-row")(
        waIcon(name := "arrow-right")(""),
        waIcon(name := "arrow-right", rotate := "90")(""),
        waIcon(name := "arrow-right", rotate := "180")(""),
        waIcon(name := "arrow-right", rotate := "270")("")
      )
    ),

    div(cls := "demo-section")(
      h2("Flip"),
      div(cls := "demo-row")(
        waIcon(name := "shield")(""),
        waIcon(name := "shield", flip := "horizontal")(""),
        waIcon(name := "shield", flip := "vertical")(""),
        waIcon(name := "shield", flip := "both")("")
      )
    ),

    div(cls := "demo-section")(
      h2("Auto-width (fixed-width disabled)"),
      div(cls := "demo-row")(
        div(attr("style") := "display: flex; flex-direction: column; gap: 0.5rem; align-items: flex-start")(
          div(
            waIcon(name := "home", autoWidth := "true")(""),
            " Home (auto)"
          ),
          div(
            waIcon(name := "circle-info", autoWidth := "true")(""),
            " Info (auto)"
          ),
          div(
            waIcon(name := "exclamation-triangle", autoWidth := "true")(""),
            " Warning (auto)"
          )
        ),
        div(attr("style") := "display: flex; flex-direction: column; gap: 0.5rem; align-items: flex-start")(
          div(
            waIcon(name := "home")(""),
            " Home (fixed)"
          ),
          div(
            waIcon(name := "circle-info")(""),
            " Info (fixed)"
          ),
          div(
            waIcon(name := "exclamation-triangle")(""),
            " Warning (fixed)"
          )
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Animation"),
      div(cls := "demo-row")(
        waIcon(name := "spinner", animation := "spin")(""),
        waIcon(name := "circle-notch", animation := "spin")(""),
        waIcon(name := "sync", animation := "spin")(""),
        waIcon(name := "cog", animation := "spin")(""),
        waIcon(name := "heart", animation := "beat")("")
      )
    ),

    div(cls := "demo-section")(
      h2("Common UI icons"),
      div(cls := "demo-row")(
        waIcon(name := "bars")(""),
        waIcon(name := "xmark")(""),
        waIcon(name := "magnifying-glass")(""),
        waIcon(name := "bell")(""),
        waIcon(name := "envelope")(""),
        waIcon(name := "calendar")(""),
        waIcon(name := "download")(""),
        waIcon(name := "upload")(""),
        waIcon(name := "trash")(""),
        waIcon(name := "pen")("")
      )
    ),

    div(cls := "demo-section")(
      h2("Social & brand icons"),
      div(cls := "demo-row")(
        waIcon(name := "github", library := "brands")(""),
        waIcon(name := "twitter", library := "brands")(""),
        waIcon(name := "facebook", library := "brands")(""),
        waIcon(name := "linkedin", library := "brands")(""),
        waIcon(name := "youtube", library := "brands")("")
      )
    ),

    div(cls := "demo-section")(
      h2("File type icons"),
      div(cls := "demo-row")(
        waIcon(name := "file")(""),
        waIcon(name := "file-pdf")(""),
        waIcon(name := "file-word")(""),
        waIcon(name := "file-excel")(""),
        waIcon(name := "file-powerpoint")(""),
        waIcon(name := "file-image")(""),
        waIcon(name := "file-video")(""),
        waIcon(name := "file-audio")(""),
        waIcon(name := "file-code")(""),
        waIcon(name := "file-zipper")("")
      )
    ),

    div(cls := "demo-section")(
      h2("Status & feedback icons"),
      div(cls := "demo-row")(
        waIcon(name := "circle-check", attr("style") := "color: green")(""),
        waIcon(name := "circle-xmark", attr("style") := "color: red")(""),
        waIcon(name := "circle-exclamation", attr("style") := "color: orange")(""),
        waIcon(name := "circle-info", attr("style") := "color: blue")(""),
        waIcon(name := "triangle-exclamation", attr("style") := "color: orange")("")
      )
    ),

    div(cls := "demo-section")(
      h2("In buttons"),
      div(cls := "demo-row")(
        waButton(variant := "brand")(
          waIcon(slot := "prefix", name := "floppy-disk")(""),
          "Save"
        ),
        waButton(variant := "danger")(
          waIcon(slot := "prefix", name := "trash")(""),
          "Delete"
        ),
        waButton(variant := "neutral")(
          waIcon(slot := "prefix", name := "download")(""),
          "Download"
        ),
        waButton(variant := "success")(
          "Upload",
          waIcon(slot := "suffix", name := "upload")("")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("In input fields"),
      div(cls := "demo-row")(
        waInput(
          attr("label") := "Search",
          placeholder := "Search..."
        )(
          waIcon(slot := "prefix", name := "magnifying-glass")("")
        ),
        waInput(
          attr("label") := "Email",
          placeholder := "user@example.com",
          `type` := "email"
        )(
          waIcon(slot := "prefix", name := "envelope")("")
        ),
        waInput(
          attr("label") := "Username",
          placeholder := "johndoe"
        )(
          waIcon(slot := "prefix", name := "user")("")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Colored icons"),
      div(cls := "demo-row")(
        waIcon(name := "heart", attr("style") := "color: red; font-size: 2rem")(""),
        waIcon(name := "star", attr("style") := "color: gold; font-size: 2rem")(""),
        waIcon(name := "fire", attr("style") := "color: orange; font-size: 2rem")(""),
        waIcon(name := "snowflake", attr("style") := "color: lightblue; font-size: 2rem")(""),
        waIcon(name := "leaf", attr("style") := "color: green; font-size: 2rem")("")
      )
    )
  )

  // --- Skeleton ---
  @cask.get("/skeleton")
  def skeletonPage(): cask.Response[String] = htmlPage("Skeleton", "skeleton")(
    h1("wa-skeleton"),

    div(cls := "demo-section")(
      h2("Basic skeleton"),
      div(cls := "demo-row")(
        waSkeleton(attr("style") := "width: 300px; height: 20px")
      )
    ),

    div(cls := "demo-section")(
      h2("Effect types"),
      div(cls := "demo-row")(
        div(attr("style") := "display: flex; flex-direction: column; gap: 1rem")(
          div(
            p(attr("style") := "margin-bottom: 0.5rem; font-size: 0.875rem")("None (default)"),
            waSkeleton(attr("style") := "width: 250px; height: 20px")
          ),
          div(
            p(attr("style") := "margin-bottom: 0.5rem; font-size: 0.875rem")("Pulse"),
            waSkeleton(effect := "pulse", attr("style") := "width: 250px; height: 20px")
          ),
          div(
            p(attr("style") := "margin-bottom: 0.5rem; font-size: 0.875rem")("Sheen"),
            waSkeleton(effect := "sheen", attr("style") := "width: 250px; height: 20px")
          )
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Text placeholder"),
      div(attr("style") := "display: flex; flex-direction: column; gap: 0.75rem; max-width: 500px")(
        waSkeleton(effect := "sheen", attr("style") := "width: 100%; height: 16px"),
        waSkeleton(effect := "sheen", attr("style") := "width: 90%; height: 16px"),
        waSkeleton(effect := "sheen", attr("style") := "width: 95%; height: 16px"),
        waSkeleton(effect := "sheen", attr("style") := "width: 80%; height: 16px")
      )
    ),

    div(cls := "demo-section")(
      h2("Avatar placeholder"),
      div(cls := "demo-row")(
        waSkeleton(effect := "pulse", attr("style") := "width: 48px; height: 48px; border-radius: 50%")
      )
    ),

    div(cls := "demo-section")(
      h2("Card placeholder"),
      div(attr("style") := "max-width: 400px")(
        waCard(
          div(attr("style") := "padding: 1rem")(
            div(attr("style") := "display: flex; gap: 1rem; margin-bottom: 1rem")(
              waSkeleton(effect := "pulse", attr("style") := "width: 60px; height: 60px; border-radius: 50%; flex-shrink: 0"),
              div(attr("style") := "flex: 1; display: flex; flex-direction: column; gap: 0.5rem; justify-content: center")(
                waSkeleton(effect := "sheen", attr("style") := "width: 70%; height: 16px"),
                waSkeleton(effect := "sheen", attr("style") := "width: 50%; height: 14px")
              )
            ),
            waSkeleton(effect := "pulse", attr("style") := "width: 100%; height: 200px; border-radius: 8px; margin-bottom: 1rem"),
            div(attr("style") := "display: flex; flex-direction: column; gap: 0.5rem")(
              waSkeleton(effect := "sheen", attr("style") := "width: 100%; height: 14px"),
              waSkeleton(effect := "sheen", attr("style") := "width: 95%; height: 14px"),
              waSkeleton(effect := "sheen", attr("style") := "width: 85%; height: 14px")
            )
          )
        )
      )
    ),

    div(cls := "demo-section")(
      h2("List item placeholder"),
      div(attr("style") := "display: flex; flex-direction: column; gap: 1rem; max-width: 500px")(
        div(attr("style") := "display: flex; gap: 1rem; align-items: center")(
          waSkeleton(effect := "pulse", attr("style") := "width: 40px; height: 40px; border-radius: 4px; flex-shrink: 0"),
          div(attr("style") := "flex: 1; display: flex; flex-direction: column; gap: 0.5rem")(
            waSkeleton(effect := "sheen", attr("style") := "width: 60%; height: 14px"),
            waSkeleton(effect := "sheen", attr("style") := "width: 40%; height: 12px")
          )
        ),
        div(attr("style") := "display: flex; gap: 1rem; align-items: center")(
          waSkeleton(effect := "pulse", attr("style") := "width: 40px; height: 40px; border-radius: 4px; flex-shrink: 0"),
          div(attr("style") := "flex: 1; display: flex; flex-direction: column; gap: 0.5rem")(
            waSkeleton(effect := "sheen", attr("style") := "width: 70%; height: 14px"),
            waSkeleton(effect := "sheen", attr("style") := "width: 50%; height: 12px")
          )
        ),
        div(attr("style") := "display: flex; gap: 1rem; align-items: center")(
          waSkeleton(effect := "pulse", attr("style") := "width: 40px; height: 40px; border-radius: 4px; flex-shrink: 0"),
          div(attr("style") := "flex: 1; display: flex; flex-direction: column; gap: 0.5rem")(
            waSkeleton(effect := "sheen", attr("style") := "width: 55%; height: 14px"),
            waSkeleton(effect := "sheen", attr("style") := "width: 35%; height: 12px")
          )
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Button placeholder"),
      div(cls := "demo-row")(
        waSkeleton(effect := "pulse", attr("style") := "width: 100px; height: 36px; border-radius: 6px"),
        waSkeleton(effect := "pulse", attr("style") := "width: 120px; height: 36px; border-radius: 6px"),
        waSkeleton(effect := "pulse", attr("style") := "width: 80px; height: 36px; border-radius: 6px")
      )
    ),

    div(cls := "demo-section")(
      h2("Table row placeholder"),
      div(attr("style") := "display: flex; flex-direction: column; gap: 0.75rem; max-width: 700px")(
        div(attr("style") := "display: grid; grid-template-columns: 2fr 1fr 1fr 100px; gap: 1rem")(
          waSkeleton(effect := "sheen", attr("style") := "height: 14px"),
          waSkeleton(effect := "sheen", attr("style") := "height: 14px"),
          waSkeleton(effect := "sheen", attr("style") := "height: 14px"),
          waSkeleton(effect := "sheen", attr("style") := "height: 14px")
        ),
        div(attr("style") := "display: grid; grid-template-columns: 2fr 1fr 1fr 100px; gap: 1rem")(
          waSkeleton(effect := "sheen", attr("style") := "height: 14px"),
          waSkeleton(effect := "sheen", attr("style") := "height: 14px"),
          waSkeleton(effect := "sheen", attr("style") := "height: 14px"),
          waSkeleton(effect := "sheen", attr("style") := "height: 14px")
        ),
        div(attr("style") := "display: grid; grid-template-columns: 2fr 1fr 1fr 100px; gap: 1rem")(
          waSkeleton(effect := "sheen", attr("style") := "height: 14px"),
          waSkeleton(effect := "sheen", attr("style") := "height: 14px"),
          waSkeleton(effect := "sheen", attr("style") := "height: 14px"),
          waSkeleton(effect := "sheen", attr("style") := "height: 14px")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Form placeholder"),
      div(attr("style") := "max-width: 400px; display: flex; flex-direction: column; gap: 1.5rem")(
        div(
          p(attr("style") := "margin-bottom: 0.5rem; font-size: 0.875rem; font-weight: 500")("Name"),
          waSkeleton(effect := "pulse", attr("style") := "width: 100%; height: 40px; border-radius: 6px")
        ),
        div(
          p(attr("style") := "margin-bottom: 0.5rem; font-size: 0.875rem; font-weight: 500")("Email"),
          waSkeleton(effect := "pulse", attr("style") := "width: 100%; height: 40px; border-radius: 6px")
        ),
        div(
          p(attr("style") := "margin-bottom: 0.5rem; font-size: 0.875rem; font-weight: 500")("Message"),
          waSkeleton(effect := "pulse", attr("style") := "width: 100%; height: 100px; border-radius: 6px")
        ),
        waSkeleton(effect := "pulse", attr("style") := "width: 120px; height: 40px; border-radius: 6px")
      )
    )
  )

  // --- Spinner ---
  @cask.get("/spinner")
  def spinnerPage(): cask.Response[String] = htmlPage("Spinner", "spinner")(
    h1("wa-spinner"),

    div(cls := "demo-section")(
      h2("Basic spinner"),
      div(cls := "demo-row")(
        waSpinner
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes (via CSS)"),
      div(cls := "demo-row")(
        waSpinner(attr("style") := "font-size: 1rem"),
        waSpinner(attr("style") := "font-size: 1.5rem"),
        waSpinner(attr("style") := "font-size: 2rem"),
        waSpinner(attr("style") := "font-size: 3rem"),
        waSpinner(attr("style") := "font-size: 4rem")
      )
    ),

    div(cls := "demo-section")(
      h2("Custom colors"),
      div(cls := "demo-row")(
        waSpinner(attr("style") := "--indicator-color: #0066ff; font-size: 2rem"),
        waSpinner(attr("style") := "--indicator-color: #28a745; font-size: 2rem"),
        waSpinner(attr("style") := "--indicator-color: #ffc107; font-size: 2rem"),
        waSpinner(attr("style") := "--indicator-color: #dc3545; font-size: 2rem"),
        waSpinner(attr("style") := "--indicator-color: #6c757d; font-size: 2rem")
      )
    ),

    div(cls := "demo-section")(
      h2("Custom track color"),
      div(cls := "demo-row")(
        waSpinner(attr("style") := "--track-color: #e0e0e0; font-size: 2rem"),
        waSpinner(attr("style") := "--track-color: rgba(0, 102, 255, 0.2); --indicator-color: #0066ff; font-size: 2rem"),
        waSpinner(attr("style") := "--track-color: transparent; font-size: 2rem")
      )
    ),

    div(cls := "demo-section")(
      h2("Custom track width"),
      div(cls := "demo-row")(
        waSpinner(attr("style") := "--track-width: 1px; font-size: 2rem"),
        waSpinner(attr("style") := "--track-width: 2px; font-size: 2rem"),
        waSpinner(attr("style") := "--track-width: 4px; font-size: 2rem"),
        waSpinner(attr("style") := "--track-width: 8px; font-size: 2rem")
      )
    ),

    div(cls := "demo-section")(
      h2("Custom speed"),
      div(cls := "demo-row")(
        waSpinner(attr("style") := "--speed: 0.5s; font-size: 2rem"),
        waSpinner(attr("style") := "--speed: 1s; font-size: 2rem"),
        waSpinner(attr("style") := "--speed: 2s; font-size: 2rem"),
        waSpinner(attr("style") := "--speed: 3s; font-size: 2rem")
      )
    ),

    div(cls := "demo-section")(
      h2("In buttons"),
      div(cls := "demo-row")(
        waButton(variant := "brand", loading := "true")("Loading"),
        waButton(variant := "success", loading := "true")("Processing"),
        waButton(variant := "danger", loading := "true", attr("size") := "small")("Deleting"),
        waButton(variant := "neutral", loading := "true", attr("size") := "large")("Saving")
      )
    ),

    div(cls := "demo-section")(
      h2("Loading states"),
      div(cls := "demo-row")(
        div(attr("style") := "display: flex; flex-direction: column; align-items: center; gap: 0.75rem; padding: 2rem; background: #f5f5f5; border-radius: 8px")(
          waSpinner(attr("style") := "font-size: 2rem"),
          p(attr("style") := "margin: 0; color: #666")("Loading data...")
        ),
        div(attr("style") := "display: flex; flex-direction: column; align-items: center; gap: 0.75rem; padding: 2rem; background: #f5f5f5; border-radius: 8px")(
          waSpinner(attr("style") := "--indicator-color: #0066ff; font-size: 2rem"),
          p(attr("style") := "margin: 0; color: #666")("Please wait...")
        ),
        div(attr("style") := "display: flex; flex-direction: column; align-items: center; gap: 0.75rem; padding: 2rem; background: #f5f5f5; border-radius: 8px")(
          waSpinner(attr("style") := "--indicator-color: #28a745; font-size: 2rem"),
          p(attr("style") := "margin: 0; color: #666")("Processing...")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("In cards"),
      div(cls := "demo-row")(
        waCard(attr("style") := "width: 300px")(
          div(slot := "header")(
            strong("Loading Content")
          ),
          div(attr("style") := "display: flex; flex-direction: column; align-items: center; padding: 3rem 1rem")(
            waSpinner(attr("style") := "font-size: 2.5rem; margin-bottom: 1rem"),
            p(attr("style") := "margin: 0; color: #666; text-align: center")("Fetching your data...")
          )
        ),
        waCard(attr("style") := "width: 300px")(
          div(slot := "header")(
            strong("Upload in Progress")
          ),
          div(attr("style") := "display: flex; flex-direction: column; align-items: center; padding: 3rem 1rem")(
            waSpinner(attr("style") := "--indicator-color: #0066ff; font-size: 2.5rem; margin-bottom: 1rem"),
            p(attr("style") := "margin: 0; color: #666; text-align: center")("Uploading files..."),
            p(attr("style") := "margin: 0.5rem 0 0 0; color: #999; font-size: 0.875rem")("75% complete")
          )
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Inline with text"),
      div(attr("style") := "display: flex; flex-direction: column; gap: 1rem")(
        p(attr("style") := "display: flex; align-items: center; gap: 0.5rem; margin: 0")(
          waSpinner(attr("style") := "font-size: 1rem"),
          "Loading your profile..."
        ),
        p(attr("style") := "display: flex; align-items: center; gap: 0.5rem; margin: 0")(
          waSpinner(attr("style") := "--indicator-color: #28a745; font-size: 1rem"),
          "Synchronizing data..."
        ),
        p(attr("style") := "display: flex; align-items: center; gap: 0.5rem; margin: 0")(
          waSpinner(attr("style") := "--indicator-color: #ffc107; font-size: 1rem"),
          "Preparing download..."
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Combined customization"),
      div(cls := "demo-row")(
        waSpinner(attr("style") := "--indicator-color: #0066ff; --track-color: rgba(0, 102, 255, 0.15); --track-width: 4px; --speed: 1.5s; font-size: 3rem"),
        waSpinner(attr("style") := "--indicator-color: #28a745; --track-color: rgba(40, 167, 69, 0.15); --track-width: 3px; --speed: 0.8s; font-size: 3rem"),
        waSpinner(attr("style") := "--indicator-color: #dc3545; --track-color: transparent; --track-width: 5px; --speed: 1s; font-size: 3rem")
      )
    ),

    div(cls := "demo-section")(
      h2("Dark background"),
      div(attr("style") := "background: #1a1a2e; padding: 2rem; border-radius: 8px; display: flex; gap: 2rem; justify-content: center")(
        waSpinner(attr("style") := "--indicator-color: #ffffff; --track-color: rgba(255, 255, 255, 0.2); font-size: 2rem"),
        waSpinner(attr("style") := "--indicator-color: #4ecdc4; --track-color: rgba(78, 205, 196, 0.2); font-size: 2rem"),
        waSpinner(attr("style") := "--indicator-color: #ff6b6b; --track-color: rgba(255, 107, 107, 0.2); font-size: 2rem"),
        waSpinner(attr("style") := "--indicator-color: #ffe66d; --track-color: rgba(255, 230, 109, 0.2); font-size: 2rem")
      )
    )
  )

  @cask.get("/tag")
  def tagPage(): cask.Response[String] = htmlPage("Tag", "tag")(
    h1("wa-tag"),

    div(cls := "demo-section")(
      h2("Variants"),
      div(cls := "demo-row")(
        waTag(variant := "neutral")("Neutral"),
        waTag(variant := "brand")("Brand"),
        waTag(variant := "success")("Success"),
        waTag(variant := "warning")("Warning"),
        waTag(variant := "danger")("Danger")
      )
    ),

    div(cls := "demo-section")(
      h2("Appearances"),
      div(cls := "demo-row")(
        waTag(appearance := "accent")("Accent"),
        waTag(appearance := "filled")("Filled"),
        waTag(appearance := "outlined")("Outlined"),
        waTag(appearance := "filled-outlined")("Filled Outlined")
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waTag(attr("size") := "small")("Small"),
        waTag(attr("size") := "medium")("Medium"),
        waTag(attr("size") := "large")("Large")
      )
    ),

    div(cls := "demo-section")(
      h2("Pill style"),
      div(cls := "demo-row")(
        waTag(pill := "true", variant := "brand")("Pill tag"),
        waTag(pill := "true", variant := "success")("Success"),
        waTag(pill := "true", variant := "warning")("Warning"),
        waTag(pill := "true", variant := "danger")("Danger")
      )
    ),

    div(cls := "demo-section")(
      h2("Removable tags"),
      div(cls := "demo-row")(
        waTag(withRemove := "true")("Removable"),
        waTag(withRemove := "true", variant := "brand")("Brand"),
        waTag(withRemove := "true", variant := "success")("Success"),
        waTag(withRemove := "true", variant := "danger")("Danger")
      )
    ),

    div(cls := "demo-section")(
      h2("Removable pill tags"),
      div(cls := "demo-row")(
        waTag(withRemove := "true", pill := "true", variant := "neutral")("Neutral"),
        waTag(withRemove := "true", pill := "true", variant := "brand")("Brand"),
        waTag(withRemove := "true", pill := "true", variant := "success")("Success"),
        waTag(withRemove := "true", pill := "true", variant := "warning")("Warning"),
        waTag(withRemove := "true", pill := "true", variant := "danger")("Danger")
      )
    ),

    div(cls := "demo-section")(
      h2("Combined: sizes + removable"),
      div(cls := "demo-row")(
        waTag(withRemove := "true", attr("size") := "small", variant := "brand")("Small removable"),
        waTag(withRemove := "true", attr("size") := "medium", variant := "brand")("Medium removable"),
        waTag(withRemove := "true", attr("size") := "large", variant := "brand")("Large removable")
      )
    ),

    div(cls := "demo-section")(
      h2("Tag groups"),
      div(attr("style") := "display: flex; flex-direction: column; gap: 1rem")(
        div(attr("style") := "display: flex; gap: 0.5rem; flex-wrap: wrap")(
          waTag(variant := "brand")("React"),
          waTag(variant := "brand")("Vue"),
          waTag(variant := "brand")("Angular"),
          waTag(variant := "brand")("Svelte")
        ),
        div(attr("style") := "display: flex; gap: 0.5rem; flex-wrap: wrap")(
          waTag(withRemove := "true", pill := "true", variant := "success")("TypeScript"),
          waTag(withRemove := "true", pill := "true", variant := "success")("JavaScript"),
          waTag(withRemove := "true", pill := "true", variant := "success")("Python"),
          waTag(withRemove := "true", pill := "true", variant := "success")("Scala")
        ),
        div(attr("style") := "display: flex; gap: 0.5rem; flex-wrap: wrap")(
          waTag(appearance := "outlined", attr("size") := "small")("v1.0.0"),
          waTag(appearance := "outlined", attr("size") := "small")("v2.1.3"),
          waTag(appearance := "outlined", attr("size") := "small")("v3.0.0-beta")
        )
      )
    )
  )

  // --- Progress Bar ---
  @cask.get("/progress-bar")
  def progressBarPage(): cask.Response[String] = htmlPage("Progress Bar", "progress-bar")(
    h1("wa-progress-bar"),

    div(cls := "demo-section")(
      h2("Basic progress"),
      div(cls := "demo-row")(
        waProgressBar(value := "0"),
        waProgressBar(value := "25"),
        waProgressBar(value := "50"),
        waProgressBar(value := "75"),
        waProgressBar(value := "100")
      )
    ),

    div(cls := "demo-section")(
      h2("With label"),
      div(cls := "demo-row")(
        waProgressBar(value := "25", attr("label") := "Uploading..."),
        waProgressBar(value := "50", attr("label") := "Processing..."),
        waProgressBar(value := "75", attr("label") := "Almost done...")
      )
    ),

    div(cls := "demo-section")(
      h2("Indeterminate"),
      div(cls := "demo-row")(
        waProgressBar(indeterminate := "true"),
        waProgressBar(indeterminate := "true", attr("label") := "Loading...")
      )
    )
  )

  // --- Progress Ring ---
  @cask.get("/progress-ring")
  def progressRingPage(): cask.Response[String] = htmlPage("Progress Ring", "progress-ring")(
    h1("wa-progress-ring"),

    div(cls := "demo-section")(
      h2("Basic progress"),
      div(cls := "demo-row")(
        waProgressRing(value := "0"),
        waProgressRing(value := "25"),
        waProgressRing(value := "50"),
        waProgressRing(value := "75"),
        waProgressRing(value := "100")
      )
    ),

    div(cls := "demo-section")(
      h2("With label"),
      div(cls := "demo-row")(
        waProgressRing(value := "25", attr("label") := "Uploading..."),
        waProgressRing(value := "50", attr("label") := "Processing..."),
        waProgressRing(value := "75", attr("label") := "Almost done...")
      )
    ),

    div(cls := "demo-section")(
      h2("Sizes"),
      div(cls := "demo-row")(
        waProgressRing(value := "50", attr("size") := "50"),
        waProgressRing(value := "50", attr("size") := "75"),
        waProgressRing(value := "50", attr("size") := "100"),
        waProgressRing(value := "50", attr("size") := "125")
      )
    ),

    div(cls := "demo-section")(
      h2("Indeterminate"),
      div(cls := "demo-row")(
        waProgressRing(indeterminate := "true"),
        waProgressRing(indeterminate := "true", attr("label") := "Loading...")
      )
    )
  )

  initialize()
