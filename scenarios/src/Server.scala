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

  // --- Breadcrumb ---
  @cask.get("/breadcrumb")
  def breadcrumbPage(): cask.Response[String] = htmlPage("Breadcrumb", "breadcrumb")(
    h1("wa-breadcrumb"),

    div(cls := "demo-section")(
      h2("Basic breadcrumb with links"),
      div(cls := "demo-row")(
        waBreadcrumb(attr("label") := "Navigation breadcrumb")(
          a(href := "#home")("Home"),
          a(href := "#products")("Products"),
          a(href := "#category")("Category"),
          "Current Page"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Without aria label"),
      div(cls := "demo-row")(
        waBreadcrumb(
          a(href := "#")("Docs"),
          a(href := "#")("Components"),
          "Breadcrumb"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With custom separator (icon)"),
      div(cls := "demo-row")(
        waBreadcrumb(attr("label") := "File path")(
          waIcon(name := "chevron-right", slot := "separator"),
          a(href := "#")("Home"),
          a(href := "#")("Documents"),
          a(href := "#")("Projects"),
          "Report.pdf"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With custom separator (text)"),
      div(cls := "demo-row")(
        waBreadcrumb(
          tag("span")(slot := "separator")(" > "),
          a(href := "#")("Root"),
          a(href := "#")("Folder"),
          "File"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Long breadcrumb trail"),
      div(cls := "demo-row")(
        waBreadcrumb(attr("label") := "Site navigation")(
          a(href := "#")("Home"),
          a(href := "#")("Category"),
          a(href := "#")("Subcategory"),
          a(href := "#")("Product Type"),
          a(href := "#")("Brand"),
          "Product Name"
        )
      )
    )
  )

  // --- Breadcrumb Item ---
  @cask.get("/breadcrumb-item")
  def breadcrumbItemPage(): cask.Response[String] = htmlPage("Breadcrumb Item", "breadcrumb-item")(
    h1("wa-breadcrumb-item"),

    div(cls := "demo-section")(
      h2("Basic breadcrumb items with links"),
      div(cls := "demo-row")(
        waBreadcrumb(
          waBreadcrumbItem(href := "#home")("Home"),
          waBreadcrumbItem(href := "#products")("Products"),
          waBreadcrumbItem(href := "#category")("Category"),
          waBreadcrumbItem("Current Page")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With icons in start slot"),
      div(cls := "demo-row")(
        waBreadcrumb(
          waBreadcrumbItem(href := "#")(
            waIcon(name := "house", slot := "start"),
            "Home"
          ),
          waBreadcrumbItem(href := "#")(
            waIcon(name := "folder", slot := "start"),
            "Documents"
          ),
          waBreadcrumbItem(
            waIcon(name := "file", slot := "start"),
            "Report.pdf"
          )
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With icons in end slot"),
      div(cls := "demo-row")(
        waBreadcrumb(
          waBreadcrumbItem(href := "#")(
            "Home",
            waIcon(name := "chevron-right", slot := "end")
          ),
          waBreadcrumbItem(href := "#")(
            "Products",
            waIcon(name := "chevron-right", slot := "end")
          ),
          waBreadcrumbItem("Current")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With custom separator per item"),
      div(cls := "demo-row")(
        waBreadcrumb(
          waBreadcrumbItem(href := "#")(
            waIcon(name := "arrow-right", slot := "separator"),
            "Home"
          ),
          waBreadcrumbItem(href := "#")(
            waIcon(name := "arrow-right", slot := "separator"),
            "Docs"
          ),
          waBreadcrumbItem("Current")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Mixed: links and buttons"),
      div(cls := "demo-row")(
        waBreadcrumb(
          waBreadcrumbItem(href := "#")("Link Item"),
          waBreadcrumbItem("Button Item"),
          waBreadcrumbItem(href := "#")("Another Link"),
          waBreadcrumbItem("Current")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With target and rel attributes"),
      div(cls := "demo-row")(
        waBreadcrumb(
          waBreadcrumbItem(href := "#", target := "_self")("Internal"),
          waBreadcrumbItem(href := "https://example.com", target := "_blank", rel := "noopener")("External"),
          waBreadcrumbItem("Current")
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
      h2("Card with header, media, and footer"),
      waCard(withHeader := "true", withMedia := "true", withFooter := "true")(
        div(slot := "header")(
          strong("Card with All Sections")
        ),
        div(slot := "media")(
          img(
            src := "https://images.unsplash.com/photo-1559209172-6a2cf814cdbb?w=600&h=300&fit=crop",
            alt := "Placeholder"
          )
        ),
        p("Card body content goes here. You can put any HTML inside."),
        div(slot := "footer")(
          waButton(variant := "brand")("Action"),
          waButton(appearance := "plain")("Cancel")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Card with header only"),
      waCard(withHeader := "true")(
        div(slot := "header")(
          strong("Card Title")
        ),
        p("This card only has a header section enabled.")
      )
    ),

    div(cls := "demo-section")(
      h2("Card with footer only"),
      waCard(withFooter := "true")(
        p("This card only has a footer section enabled."),
        div(slot := "footer")(
          waButton(variant := "brand", attr("size") := "small")("Save"),
          waButton(appearance := "plain", attr("size") := "small")("Cancel")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Horizontal orientation"),
      waCard(withMedia := "true", orientation := "horizontal")(
        div(slot := "media")(
          img(
            src := "https://images.unsplash.com/photo-1559209172-6a2cf814cdbb?w=200&h=200&fit=crop",
            alt := "Placeholder"
          )
        ),
        strong("Horizontal Layout"),
        p("With horizontal orientation, the media appears on the side.")
      )
    ),

    div(cls := "demo-section")(
      h2("Multiple cards"),
      div(cls := "demo-row")(
        waCard(withHeader := "true", attr("style") := "width: 250px")(
          div(slot := "header")(strong("First")),
          p("First card content")
        ),
        waCard(withHeader := "true", attr("style") := "width: 250px")(
          div(slot := "header")(strong("Second")),
          p("Second card content")
        ),
        waCard(withHeader := "true", attr("style") := "width: 250px")(
          div(slot := "header")(strong("Third")),
          p("Third card content")
        )
      )
    )
  )

  // --- Details ---
  @cask.get("/details")
  def detailsPage(): cask.Response[String] = htmlPage("Details", "details")(
    h1("wa-details"),

    div(cls := "demo-section")(
      h2("Basic details"),
      waDetails(summary := "Click to expand")(
        "This is the content that appears when you expand the details element. It can contain any HTML."
      )
    ),

    div(cls := "demo-section")(
      h2("Open by default"),
      waDetails(summary := "This is open initially", attr("open") := "true")(
        "The details element can be rendered in an open state by adding the 'open' attribute."
      )
    ),

    div(cls := "demo-section")(
      h2("Icon placement"),
      div(attr("style") := "display: flex; flex-direction: column; gap: 1rem")(
        waDetails(summary := "Icon on start (default)")(
          "The disclosure icon appears on the left by default."
        ),
        waDetails(summary := "Icon on end", iconPlacement := "end")(
          "You can move the disclosure icon to the right using icon-placement=\"end\"."
        ),
        waDetails(summary := "No icon", iconPlacement := "none")(
          "Or hide the icon completely with icon-placement=\"none\"."
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Nested details"),
      waDetails(summary := "Level 1")(
        p("First level content."),
        waDetails(summary := "Level 2", attr("style") := "margin-left: 1rem")(
          p("Second level content."),
          waDetails(summary := "Level 3", attr("style") := "margin-left: 1rem")(
            "Third level content. Details can be nested to create hierarchical structures."
          )
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Rich content"),
      waDetails(summary := "Frequently Asked Questions")(
        div(
          p(strong("Q: What is Web Awesome?")),
          p("A: Web Awesome is a UI component library built with web components."),
          p(strong("Q: How do I use it?")),
          p("A: Simply include the CSS and JS loader, then use the wa-* custom elements.")
        )
      )
    )
  )

  // --- Dialog ---
  @cask.get("/dialog")
  def dialogPage(): cask.Response[String] = htmlPage("Dialog", "dialog")(
    h1("wa-dialog"),

    div(cls := "demo-section")(
      h2("Basic dialog (open by default)"),
      waDialog(open := "true")(
        div(slot := "header")("Dialog Header"),
        p("This is a basic dialog with a header and some content."),
        div(slot := "footer")(
          waButton(variant := "brand")("Confirm"),
          waButton(appearance := "outlined")("Cancel")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Dialog without header"),
      waDialog(open := "true", withoutHeader := "true")(
        p("This dialog has no header section, just the content area."),
        p("Notice there's no top section with a title."),
        div(slot := "footer")(
          waButton(variant := "success")("OK")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Dialog with light dismiss"),
      waDialog(open := "true", lightDismiss := "true")(
        div(slot := "header")("Click Outside to Close"),
        p("This dialog can be dismissed by clicking outside of it or pressing Escape."),
        p("The light-dismiss attribute enables this behavior."),
        div(slot := "footer")(
          waButton(variant := "brand")("Got it")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Dialog with rich content"),
      waDialog(open := "true")(
        div(slot := "header")(
          waIcon(name := "fa-solid:circle-info"),
          " Information"
        ),
        div(
          p("Dialogs can contain any HTML content including:"),
          ul(
            li("Lists and formatted text"),
            li("Images and icons"),
            li("Form controls"),
            li("Other Web Awesome components")
          ),
          waInput(attr("label") := "Your name", placeholder := "Enter your name"),
          waCheckbox("I agree to the terms")
        ),
        div(slot := "footer")(
          waButton(variant := "brand")("Submit"),
          waButton(appearance := "plain")("Cancel")
        )
      )
    )
  )

  // --- Drawer ---
  @cask.get("/drawer")
  def drawerPage(): cask.Response[String] = htmlPage("Drawer", "drawer")(
    h1("wa-drawer"),

    div(cls := "demo-section")(
      h2("Drawer from end (default)"),
      waDrawer(open := "true", attr("label") := "Drawer Title")(
        p("This is a drawer that slides in from the right side (end placement)."),
        p("Drawers are useful for navigation menus, filters, or additional content."),
        div(slot := "footer")(
          waButton(variant := "brand")("Confirm"),
          waButton(appearance := "outlined")("Cancel")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Drawer from start"),
      waDrawer(open := "true", placement := "start", attr("label") := "Navigation")(
        p("This drawer slides in from the left side."),
        p("Common for navigation menus and sidebars."),
        div(
          waButton(appearance := "plain", style := "display: block; width: 100%; text-align: left; margin-bottom: 0.5rem;")("Dashboard"),
          waButton(appearance := "plain", style := "display: block; width: 100%; text-align: left; margin-bottom: 0.5rem;")("Settings"),
          waButton(appearance := "plain", style := "display: block; width: 100%; text-align: left; margin-bottom: 0.5rem;")("Profile"),
          waButton(appearance := "plain", style := "display: block; width: 100%; text-align: left;")("Logout")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Drawer from top"),
      waDrawer(open := "true", placement := "top", attr("label") := "Notifications")(
        p("This drawer slides in from the top."),
        p("Useful for notifications, alerts, or temporary messages."),
        div(slot := "footer")(
          waButton(variant := "success")("Mark all as read")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Drawer from bottom"),
      waDrawer(open := "true", placement := "bottom", attr("label") := "More Options")(
        p("This drawer slides in from the bottom."),
        p("Often used for mobile-style action sheets or additional options."),
        div(slot := "footer")(
          waButton(variant := "brand")("Save"),
          waButton(appearance := "outlined")("Discard")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Drawer with header actions"),
      waDrawer(open := "true", attr("label") := "Settings")(
        div(slot := "header-actions")(
          waButton(appearance := "plain", attr("size") := "small")(
            waIcon(name := "fa-solid:gear")
          )
        ),
        p("This drawer includes action buttons in the header."),
        p("The header-actions slot allows you to add custom controls."),
        div(
          waSwitch("Enable notifications"),
          br(),
          waSwitch("Dark mode"),
          br(),
          waSwitch("Auto-save")
        ),
        div(slot := "footer")(
          waButton(variant := "brand")("Apply"),
          waButton(appearance := "outlined")("Reset")
        )
      )
    )
  )

  // --- Divider ---
  @cask.get("/divider")
  def dividerPage(): cask.Response[String] = htmlPage("Divider", "divider")(
    h1("wa-divider"),

    div(cls := "demo-section")(
      h2("Horizontal (default)"),
      div(
        p("Section 1: Some content above the divider."),
        waDivider(),
        p("Section 2: Some content below the divider.")
      )
    ),

    div(cls := "demo-section")(
      h2("Vertical orientation"),
      div(style := "display: flex; align-items: center; gap: 1rem; height: 100px;")(
        span("Left content"),
        waDivider(orientation := "vertical"),
        span("Right content")
      )
    ),

    div(cls := "demo-section")(
      h2("Separating sections"),
      div(
        h3("Introduction"),
        p("This is the first section with some introductory text."),
        waDivider(),
        h3("Main Content"),
        p("This is the main content section."),
        waDivider(),
        h3("Conclusion"),
        p("This is the concluding section.")
      )
    ),

    div(cls := "demo-section")(
      h2("With inline items"),
      div(style := "display: flex; align-items: center; gap: 1rem;")(
        waButton(variant := "brand")("Save"),
        waDivider(orientation := "vertical"),
        waButton(appearance := "outlined")("Cancel"),
        waDivider(orientation := "vertical"),
        waButton(appearance := "plain")("Reset")
      )
    )
  )

  // --- Split Panel ---
  @cask.get("/split-panel")
  def splitPanelPage(): cask.Response[String] = htmlPage("Split Panel", "split-panel")(
    h1("wa-split-panel"),

    div(cls := "demo-section")(
      h2("Horizontal (default)"),
      div(style := "height: 300px; border: 1px solid #ccc;")(
        waSplitPanel(
          div(slot := "start", style := "padding: 1rem; background: #f0f0f0;")("Start panel content"),
          div(slot := "end", style := "padding: 1rem; background: #e0e0e0;")("End panel content")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Vertical orientation"),
      div(style := "height: 400px; border: 1px solid #ccc;")(
        waSplitPanel(orientation := "vertical")(
          div(slot := "start", style := "padding: 1rem; background: #f0f0f0;")("Top panel content"),
          div(slot := "end", style := "padding: 1rem; background: #e0e0e0;")("Bottom panel content")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Custom position (30%)"),
      div(style := "height: 300px; border: 1px solid #ccc;")(
        waSplitPanel(attr("position") := "30")(
          div(slot := "start", style := "padding: 1rem; background: #f0f0f0;")("Start panel (30%)"),
          div(slot := "end", style := "padding: 1rem; background: #e0e0e0;")("End panel (70%)")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Primary panel on end"),
      div(style := "height: 300px; border: 1px solid #ccc;")(
        waSplitPanel(primary := "end")(
          div(slot := "start", style := "padding: 1rem; background: #f0f0f0;")("Start panel (secondary)"),
          div(slot := "end", style := "padding: 1rem; background: #e0e0e0;")("End panel (primary)")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Nested split panels"),
      div(style := "height: 400px; border: 1px solid #ccc;")(
        waSplitPanel(
          div(slot := "start", style := "padding: 1rem; background: #f0f0f0;")("Left sidebar"),
          waSplitPanel(slot := "end", orientation := "vertical")(
            div(slot := "start", style := "padding: 1rem; background: #e8e8e8;")("Top content area"),
            div(slot := "end", style := "padding: 1rem; background: #d0d0d0;")("Bottom content area")
          )
        )
      )
    )
  )

  // --- Tab ---
  @cask.get("/tab")
  def tabPage(): cask.Response[String] = htmlPage("Tab", "tab")(
    h1("wa-tab / wa-tab-group / wa-tab-panel"),

    div(cls := "demo-section")(
      h2("Basic tabs"),
      waTabGroup(
        waTab(slot := "nav", panel := "general")("General"),
        waTab(slot := "nav", panel := "custom")("Custom"),
        waTab(slot := "nav", panel := "advanced")("Advanced"),

        waTabPanel(name := "general")("This is the general tab panel."),
        waTabPanel(name := "custom")("This is the custom tab panel."),
        waTabPanel(name := "advanced")("This is the advanced tab panel.")
      )
    ),

    div(cls := "demo-section")(
      h2("Placement variations"),
      p("Bottom placement:"),
      waTabGroup(placement := "bottom")(
        waTab(slot := "nav", panel := "p1")("Panel 1"),
        waTab(slot := "nav", panel := "p2")("Panel 2"),
        waTab(slot := "nav", panel := "p3")("Panel 3"),

        waTabPanel(name := "p1")("Content of panel 1"),
        waTabPanel(name := "p2")("Content of panel 2"),
        waTabPanel(name := "p3")("Content of panel 3")
      )
    ),

    div(cls := "demo-section")(
      h2("Tabs with icons"),
      waTabGroup(
        waTab(slot := "nav", panel := "home")(
          waIcon(name := "house", slot := "icon-prefix"),
          "Home"
        ),
        waTab(slot := "nav", panel := "profile")(
          waIcon(name := "user", slot := "icon-prefix"),
          "Profile"
        ),
        waTab(slot := "nav", panel := "settings")(
          waIcon(name := "gear", slot := "icon-prefix"),
          "Settings"
        ),

        waTabPanel(name := "home")("Welcome home!"),
        waTabPanel(name := "profile")("User profile details go here."),
        waTabPanel(name := "settings")("Settings panel content.")
      )
    ),

    div(cls := "demo-section")(
      h2("Disabled tab"),
      waTabGroup(
        waTab(slot := "nav", panel := "tab1")("Active"),
        waTab(slot := "nav", panel := "tab2", disabled)("Disabled"),
        waTab(slot := "nav", panel := "tab3")("Another Active"),

        waTabPanel(name := "tab1")("First panel"),
        waTabPanel(name := "tab2")("This panel is linked to a disabled tab"),
        waTabPanel(name := "tab3")("Third panel")
      )
    ),

    div(cls := "demo-section")(
      h2("Manual activation"),
      p("Tabs activate on click instead of on focus:"),
      waTabGroup(activation := "manual")(
        waTab(slot := "nav", panel := "m1")("Manual 1"),
        waTab(slot := "nav", panel := "m2")("Manual 2"),
        waTab(slot := "nav", panel := "m3")("Manual 3"),

        waTabPanel(name := "m1")("Manual activation panel 1"),
        waTabPanel(name := "m2")("Manual activation panel 2"),
        waTabPanel(name := "m3")("Manual activation panel 3")
      )
    )
  )

  // --- Tree ---
  @cask.get("/tree")
  def treePage(): cask.Response[String] = htmlPage("Tree", "tree")(
    h1("wa-tree / wa-tree-item"),

    div(cls := "demo-section")(
      h2("Basic tree"),
      waTree(
        waTreeItem("Item 1"),
        waTreeItem("Item 2")(
          waTreeItem("Item 2.1"),
          waTreeItem("Item 2.2")(
            waTreeItem("Item 2.2.1"),
            waTreeItem("Item 2.2.2")
          ),
          waTreeItem("Item 2.3")
        ),
        waTreeItem("Item 3")
      )
    ),

    div(cls := "demo-section")(
      h2("Expanded by default"),
      waTree(
        waTreeItem("Root")(
          waTreeItem(expanded := "true")("Expanded parent")(
            waTreeItem("Child 1"),
            waTreeItem("Child 2")
          ),
          waTreeItem("Collapsed parent")(
            waTreeItem("Child A"),
            waTreeItem("Child B")
          )
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Selection modes"),
      p("Single selection (default):"),
      waTree(
        waTreeItem("File 1"),
        waTreeItem("Folder 1")(
          waTreeItem("File 1.1"),
          waTreeItem("File 1.2")
        ),
        waTreeItem("File 2")
      ),
      p("Multiple selection:"),
      waTree(selection := "multiple")(
        waTreeItem("Document 1"),
        waTreeItem("Folder")(
          waTreeItem("Document 2"),
          waTreeItem("Document 3")
        ),
        waTreeItem("Document 4")
      ),
      p("Leaf selection only:"),
      waTree(selection := "leaf")(
        waTreeItem("Parent 1")(
          waTreeItem("Selectable leaf 1"),
          waTreeItem("Selectable leaf 2")
        ),
        waTreeItem("Parent 2")(
          waTreeItem("Selectable leaf 3")
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Lazy loading"),
      p("Tree items can be loaded on demand:"),
      waTree(
        waTreeItem("Static item"),
        waTreeItem(`lazy` := "true")("Lazy parent (expand to load children)")
      )
    ),

    div(cls := "demo-section")(
      h2("With icons"),
      waTree(
        waTreeItem(
          waIcon(name := "folder", slot := "icon-prefix"),
          "Projects"
        )(
          waTreeItem(
            waIcon(name := "folder", slot := "icon-prefix"),
            "Web App"
          )(
            waTreeItem(
              waIcon(name := "file-code", slot := "icon-prefix"),
              "index.html"
            ),
            waTreeItem(
              waIcon(name := "file-code", slot := "icon-prefix"),
              "styles.css"
            )
          ),
          waTreeItem(
            waIcon(name := "folder", slot := "icon-prefix"),
            "API"
          )(
            waTreeItem(
              waIcon(name := "file-code", slot := "icon-prefix"),
              "server.js"
            )
          )
        ),
        waTreeItem(
          waIcon(name := "folder", slot := "icon-prefix"),
          "Documents"
        )(
          waTreeItem(
            waIcon(name := "file", slot := "icon-prefix"),
            "README.md"
          )
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

  // --- Popover ---
  @cask.get("/popover")
  def popoverPage(): cask.Response[String] = htmlPage("Popover", "popover")(
    h1("wa-popover"),

    div(cls := "demo-section")(
      h2("Basic popover"),
      div(cls := "demo-row")(
        waButton(id := "popover-trigger-1")("Click me"),
        waPopover(attr("for") := "popover-trigger-1")(
          "This is a basic popover with default placement."
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Placement options"),
      div(cls := "demo-row")(
        waButton(id := "popover-top")("Top"),
        waPopover(attr("for") := "popover-top", placement := "top")(
          "Popover appears above"
        ),
        waButton(id := "popover-bottom")("Bottom"),
        waPopover(attr("for") := "popover-bottom", placement := "bottom")(
          "Popover appears below"
        ),
        waButton(id := "popover-left")("Left"),
        waPopover(attr("for") := "popover-left", placement := "left")(
          "Popover appears to the left"
        ),
        waButton(id := "popover-right")("Right"),
        waPopover(attr("for") := "popover-right", placement := "right")(
          "Popover appears to the right"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Open by default"),
      div(cls := "demo-row")(
        waButton(id := "popover-open")("Always visible"),
        waPopover(attr("for") := "popover-open", open := "true")(
          "This popover is always open"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Without arrow"),
      div(cls := "demo-row")(
        waButton(id := "popover-no-arrow")("No arrow"),
        waPopover(attr("for") := "popover-no-arrow", withoutArrow := "true")(
          "This popover has no arrow pointing to the trigger"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Distance and skidding"),
      div(cls := "demo-row")(
        waButton(id := "popover-distance")("Distance 20"),
        waPopover(attr("for") := "popover-distance", distance := "20")(
          "Offset 20px away from trigger"
        ),
        waButton(id := "popover-skidding")("Skidding 20"),
        waPopover(attr("for") := "popover-skidding", skidding := "20")(
          "Offset 20px along the trigger"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Rich content"),
      div(cls := "demo-row")(
        waButton(id := "popover-rich", variant := "brand")("Info"),
        waPopover(attr("for") := "popover-rich", placement := "top")(
          strong("Product Information"),
          p(attr("style") := "margin: 0.5rem 0")("This product includes all the features you need."),
          waButton(attr("size") := "small", appearance := "outlined")("Learn More")
        )
      )
    )
  )

  // --- Popup ---
  @cask.get("/popup")
  def popupPage(): cask.Response[String] = htmlPage("Popup", "popup")(
    h1("wa-popup"),

    div(cls := "demo-section")(
      h2("Basic popup (active on hover)"),
      div(cls := "demo-row")(
        span(id := "popup-anchor-1", attr("style") := "display: inline-block; padding: 0.5rem 1rem; background: #0066ff; color: white; border-radius: 4px; cursor: pointer")(
          "Hover me"
        ),
        waPopup(anchor := "popup-anchor-1", active := "true", placement := "top")(
          "This is a basic popup"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Placement options"),
      div(cls := "demo-row")(
        span(id := "popup-top", attr("style") := "display: inline-block; padding: 0.5rem; background: #eee; border-radius: 4px; margin: 0.5rem")(
          "Top"
        ),
        waPopup(anchor := "popup-top", active := "true", placement := "top")(
          "Popup above"
        ),
        span(id := "popup-bottom", attr("style") := "display: inline-block; padding: 0.5rem; background: #eee; border-radius: 4px; margin: 0.5rem")(
          "Bottom"
        ),
        waPopup(anchor := "popup-bottom", active := "true", placement := "bottom")(
          "Popup below"
        ),
        span(id := "popup-left", attr("style") := "display: inline-block; padding: 0.5rem; background: #eee; border-radius: 4px; margin: 0.5rem")(
          "Left"
        ),
        waPopup(anchor := "popup-left", active := "true", placement := "left")(
          "Popup left"
        ),
        span(id := "popup-right", attr("style") := "display: inline-block; padding: 0.5rem; background: #eee; border-radius: 4px; margin: 0.5rem")(
          "Right"
        ),
        waPopup(anchor := "popup-right", active := "true", placement := "right")(
          "Popup right"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("With arrow"),
      div(cls := "demo-row")(
        span(id := "popup-arrow", attr("style") := "display: inline-block; padding: 0.5rem 1rem; background: #0066ff; color: white; border-radius: 4px")(
          "Arrow popup"
        ),
        waPopup(anchor := "popup-arrow", active := "true", placement := "top", arrow := "true", distance := "8")(
          "Popup with arrow"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Distance and skidding"),
      div(cls := "demo-row")(
        span(id := "popup-distance", attr("style") := "display: inline-block; padding: 0.5rem; background: #eee; border-radius: 4px; margin: 0.5rem")(
          "Distance 20"
        ),
        waPopup(anchor := "popup-distance", active := "true", placement := "top", distance := "20")(
          "20px offset from anchor"
        ),
        span(id := "popup-skidding", attr("style") := "display: inline-block; padding: 0.5rem; background: #eee; border-radius: 4px; margin: 0.5rem")(
          "Skidding 30"
        ),
        waPopup(anchor := "popup-skidding", active := "true", placement := "top", skidding := "30")(
          "30px along anchor"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Flip and shift"),
      div(cls := "demo-row")(
        span(id := "popup-flip", attr("style") := "display: inline-block; padding: 0.5rem; background: #eee; border-radius: 4px")(
          "Flip enabled"
        ),
        waPopup(anchor := "popup-flip", active := "true", placement := "top", flip := "true")(
          "Will flip if no space above"
        )
      )
    ),

    div(cls := "demo-section")(
      h2("Sync width with anchor"),
      div(cls := "demo-row")(
        span(id := "popup-sync", attr("style") := "display: inline-block; padding: 0.5rem; background: #0066ff; color: white; border-radius: 4px; width: 200px")(
          "Wide anchor element"
        ),
        waPopup(anchor := "popup-sync", active := "true", placement := "bottom", sync := "width")(
          "Same width as anchor"
        )
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

  @cask.get("/rating")
  def ratingPage(): cask.Response[String] = htmlPage("Rating", "rating")(
    h1("wa-rating"),

    div(cls := "demo-section")(
      h2("Different ratings"),
      div(cls := "demo-row")(
        waRating(value := "0"),
        waRating(value := "1"),
        waRating(value := "2"),
        waRating(value := "3"),
        waRating(value := "4"),
        waRating(value := "5")
      )
    ),

    div(cls := "demo-section")(
      h2("Partial ratings"),
      div(cls := "demo-row")(
        waRating(value := "2.5"),
        waRating(value := "3.5"),
        waRating(value := "4.5")
      )
    ),

    div(cls := "demo-section")(
      h2("With label"),
      div(cls := "demo-row")(
        waRating(value := "3", attr("label") := "Rate this product"),
        waRating(value := "4.5", attr("label") := "Customer rating")
      )
    ),

    div(cls := "demo-section")(
      h2("Readonly"),
      div(cls := "demo-row")(
        waRating(value := "3.5", readonly := "true"),
        waRating(value := "4", readonly := "true", attr("label") := "Average rating")
      )
    ),

    div(cls := "demo-section")(
      h2("Disabled"),
      div(cls := "demo-row")(
        waRating(value := "2.5", disabled := "true"),
        waRating(value := "0", disabled := "true")
      )
    )
  )

  initialize()
