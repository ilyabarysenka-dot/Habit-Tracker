pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "HabitTracker"
include(":app")
include(":core:ui")
include(":core:notification")
include(":core:common")
include(":core:navigation")
include(":data")
include(":feature:featureFirst:api")
include(":feature:featureFirst:impl")
include(":feature:featureSecond:api")
include(":feature:featureSecond:impl")
include(":core:network")
include(":core:database")
