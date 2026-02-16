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
      h2("With hint & clear"),
      div(cls := "demo-row")(
        waInput(
          attr("label") := "Username",
          hint := "Choose a unique username",
          withClear := "true",
          placeholder := "johndoe"
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
        waColorPicker(attr("label") := "With opacity slider", opacity := "true", value := "#ff6b3580"),
        waColorPicker(attr("label") := "RGBA format", format := "rgb", opacity := "true", value := "rgba(255, 107, 53, 0.5)")
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

  initialize()
