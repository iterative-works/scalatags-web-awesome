// PURPOSE: Smoke test to verify scalatags bindings compile and produce correct HTML.
// PURPOSE: Validates that tags and attrs render expected output strings.
package works.iterative.scalatags.webawesome

import utest._

object SmokeTest extends TestSuite:
  import scalatags.Text.all._
  import WebAwesome._

  val tests = Tests:
    test("tags render correct element names"):
      assert(waButton("x").render == "<wa-button>x</wa-button>")
      assert(waBadge("3").render == "<wa-badge>3</wa-badge>")
      assert(waCard.render == "<wa-card></wa-card>")
      assert(waInput.render == "<wa-input></wa-input>")
      assert(waSwitch.render == "<wa-switch></wa-switch>")
      assert(waDialog.render == "<wa-dialog></wa-dialog>")
      assert(waIcon.render == "<wa-icon></wa-icon>")

    test("custom attrs render kebab-case names"):
      assert(waButton(variant := "brand").render == """<wa-button variant="brand"></wa-button>""")
      assert(waButton(appearance := "filled").render == """<wa-button appearance="filled"></wa-button>""")
      assert(waInput(withClear := "true").render == """<wa-input with-clear="true"></wa-input>""")
      assert(waInput(hint := "Enter name").render == """<wa-input hint="Enter name"></wa-input>""")
      assert(waDialog(lightDismiss := "true").render == """<wa-dialog light-dismiss="true"></wa-dialog>""")

    test("standard scalatags attrs work on wa elements"):
      assert(waButton(disabled := "true").render == """<wa-button disabled="true"></wa-button>""")
      assert(waInput(placeholder := "Name").render == """<wa-input placeholder="Name"></wa-input>""")
      assert(waInput(name := "email", value := "").render == """<wa-input name="email" value=""></wa-input>""")

    test("nesting and slots"):
      val html = waCard(
        div(slot := "header")("Title"),
        p("Body text")
      ).render
      assert(html == """<wa-card><div slot="header">Title</div><p>Body text</p></wa-card>""")
