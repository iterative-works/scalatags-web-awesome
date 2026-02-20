# scalatags-web-awesome

[Scalatags](https://github.com/com-lihaoyi/scalatags) bindings for [Web Awesome](https://www.webawesome.com/) web components (v3.2.1).

Provides type-safe tag and attribute definitions for all 61+ Web Awesome components, usable from both JVM (server-side HTML rendering) and ScalaJS (browser DOM).

## Setup

Add the dependency to your Mill build:

```scala
// JVM (scalatags Text backend)
def mvnDeps = Seq(mvn"works.iterative::scalatags-webawesome:3.2.1-SNAPSHOT")

// ScalaJS (scalatags JsDom backend)
def mvnDeps = Seq(mvn"works.iterative::scalatags-webawesome:3.2.1-SNAPSHOT")
```

Or in sbt:

```scala
libraryDependencies += "works.iterative" %%% "scalatags-webawesome" % "3.2.1-SNAPSHOT"
```

Your HTML pages need to load the Web Awesome runtime. Add to `<head>`:

```html
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@awesome.me/webawesome@3.2.1/dist-cdn/styles/webawesome.css">
<script type="module" src="https://cdn.jsdelivr.net/npm/@awesome.me/webawesome@3.2.1/dist-cdn/webawesome.loader.js"></script>
```

> **Important:** Use `dist-cdn/` (not `dist/`). The `dist/` directory contains bare module specifiers that require a bundler.

## Usage

```scala
import scalatags.Text.all.*
import works.iterative.scalatags.webawesome.WebAwesome.*

val page = div(
  waButton(variant := "brand", appearance := "accent")("Click me"),
  waInput(withLabel := "true", placeholder := "Enter text"),
  waBadge(variant := "success")("Active"),
  waDialog(open := "true", attr("label") := "Hello")(
    p("Dialog content"),
    waButton(slot := "footer", variant := "brand")("Close")
  )
)
```

Tags are prefixed with `wa` in camelCase (e.g., `wa-button` becomes `waButton`, `wa-color-picker` becomes `waColorPicker`).

### Attributes

Web Awesome-specific attributes are defined in the `WebAwesome` object. Standard HTML attributes (`disabled`, `placeholder`, `name`, `value`, etc.) come from scalatags as usual.

A few attributes conflict with scalatags builtins and must be used inline:

```scala
waButton(attr("size") := "large")("Large button")
waDialog(attr("label") := "Title")("Content")
```

Boolean attributes use string `"true"`:

```scala
waButton(pill := "true", loading := "true")("Loading...")
```

## Components

All 61 standard Web Awesome components are supported, organized by category:

- **Form Controls:** input, number-input, select, option, combobox, checkbox, radio, radio-group, color-picker, slider, switch, textarea
- **Actions:** button, button-group, copy-button, dropdown, dropdown-item
- **Display & Feedback:** avatar, badge, callout, icon, skeleton, spinner, tag
- **Indicators & Progress:** progress-bar, progress-ring, rating
- **Layout & Organization:** breadcrumb, breadcrumb-item, card, details, dialog, divider, drawer, split-panel
- **Navigation:** tab, tab-group, tab-panel, tree, tree-item
- **Popups & Overlays:** popover, popup, tooltip
- **Media:** animated-image, animation, carousel, carousel-item, comparison
- **Formatters & Utilities:** format-bytes, format-date, format-number, include, qr-code, relative-time, zoomable-frame
- **Observers:** intersection-observer, mutation-observer, resize-observer, scroller

### Pro Components

The following components require a [Web Awesome Pro](https://www.webawesome.com/) license:

- `wa-combobox`
- `wa-file-input`
- `wa-page`
- `wa-sparkline`

## Building

Requires [Mill](https://mill-build.org/) 1.1.2+.

```bash
./mill webawesome.jvm.compile    # Compile JVM module
./mill webawesome.js.compile     # Compile ScalaJS module
./mill webawesome.jvm.test       # Run tests
./mill webawesome.jvm.publishLocal  # Publish to ~/.ivy2/local
./mill webawesome.js.publishLocal   # Publish ScalaJS to ~/.ivy2/local
```

### Scenario Server

A built-in demo server shows all components:

```bash
./mill -w scenarios.run
# Open http://localhost:8086
```

## Versioning

Library versions mirror the Web Awesome version they target. Version `3.2.1` provides bindings for Web Awesome `3.2.1`. A fourth segment (e.g., `3.2.1.1`) indicates a fix to the bindings themselves without a Web Awesome version change.

Updates are provided on a best-effort basis — there is no guarantee of tracking every Web Awesome release.

## License

MIT
