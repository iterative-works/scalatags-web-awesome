// PURPOSE: Cask HTTP server for visually testing Web Awesome components.
// PURPOSE: Serves scenario pages with a sidebar navigation layout.
package works.iterative.scalatags.webawesome.scenarios

import scalatags.Text.all._

object Server extends cask.MainRoutes:

  override def port: Int = 8086

  @cask.get("/")
  def index(): cask.Response[String] = cask.Response(
    Layout.page("Home", "")(
      h1("Web Awesome Scenarios"),
      p("Select a component from the sidebar to see it in action.")
    ),
    headers = Seq("Content-Type" -> "text/html")
  )

  @cask.get("/hello")
  def hello(): cask.Response[String] = cask.Response(
    Layout.page("Hello World", "hello")(
      h1("Hello World"),
      p("This is a test page. Web Awesome components will appear here.")
    ),
    headers = Seq("Content-Type" -> "text/html")
  )

  initialize()
