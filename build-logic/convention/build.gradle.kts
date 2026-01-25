import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    `kotlin-dsl`
}
//In order to call Version Catalog from code (not only gradle.kts)
val catalog = the<LibrariesForLibs>()
dependencies {
    implementation(files(catalog.javaClass.superclass.protectionDomain.codeSource.location))
    compileOnly(libs.android.plugin)
    compileOnly(libs.kotlin.plugin)
}


gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.habittracker.android.application.get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = libs.plugins.habittracker.application.compose.get().pluginId
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.habittracker.android.library.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = libs.plugins.habittracker.library.compose.get().pluginId
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("kotlinLibrary") {
            id = libs.plugins.habittracker.kotlin.library.get().pluginId
            implementationClass = "KotlinLibraryConventionPlugin"
        }
    }
}