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

  initialize()
