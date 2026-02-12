// PURPOSE: Page layout template for the scenario server.
// PURPOSE: Renders sidebar navigation and content area for component testing.
package works.iterative.scalatags.webawesome.scenarios

import scalatags.Text.all._

object Layout:

  val navItems: Seq[(String, String)] = Seq(
    "hello" -> "Hello World"
  )

  def page(pageTitle: String, activePage: String)(content: Frag*): String =
    "<!DOCTYPE html>" + html(
      head(
        meta(charset := "utf-8"),
        tag("title")(s"Web Awesome Scenarios - $pageTitle"),
        tag("style")(raw(css))
      ),
      body(
        tag("nav")(cls := "sidebar")(
          h2("Components"),
          navItems.map: (id, label) =>
            a(
              href := s"/$id",
              cls := (if id == activePage then "active" else "")
            )(label)
        ),
        tag("main")(cls := "content")(
          content
        )
      )
    )

  private val css: String =
    """
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body { font-family: system-ui, sans-serif; display: flex; min-height: 100vh; }
    .sidebar {
      width: 240px; background: #1a1a2e; color: #eee; padding: 1.5rem;
      flex-shrink: 0;
    }
    .sidebar h2 {
      margin-bottom: 1rem; font-size: 0.85rem;
      text-transform: uppercase; letter-spacing: 0.05em; color: #888;
    }
    .sidebar a {
      display: block; padding: 0.5rem 0.75rem; margin-bottom: 0.25rem;
      color: #ccc; text-decoration: none; border-radius: 6px;
    }
    .sidebar a:hover { background: rgba(255,255,255,0.1); color: #fff; }
    .sidebar a.active { background: #0066ff; color: #fff; }
    .content { flex: 1; padding: 2rem; }
    .content h1 { margin-bottom: 1rem; }
    """
