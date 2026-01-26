# Convention Plugins

The `build-logic` folder defines project-specific convention plugins, used to keep a single
source of truth for common module configurations.

By setting up convention plugins in `build-logic`, we can avoid duplicated build script setup,
messy `subproject` configurations, without the pitfalls of the `buildSrc` directory.

`build-logic` is an included build, as configured in the root
[`settings.gradle.kts`](../settings.gradle.kts).

Inside `build-logic` is a `convention` module, which defines a set of plugins that all normal
modules can use to configure themselves.

`build-logic` also includes a set of `Kotlin` files used to share logic between plugins themselves,
which is most useful for configuring Android components (libraries vs applications) with shared
code.

🚀 How to use
In build.gradle.kt file of a module connect:

Android Application (Compose)
plugins {
id("habittracker.android.application")
id("habittracker.application.compose")
}

Android Application (non-Compose)
plugins {
id("habittracker.android.application")
}

Android Library (Compose)
plugins {
id("habittracker.android.library")
id("habittracker.library.compose")
}

Android Library (non-Compose)
plugins {
id("habittracker.android.library")
}

Kotlin Library
plugins {
id("habittracker.kotlin.library")
}

🛠 Adding a new convention plugin

Create a new Plugin<Project> implementation
Register it inside gradlePlugin { plugins { ... } }
Expose a plugin ID via libs.versions.toml
Apply it from modules as needed
