import com.example.habittracker.alias
import com.example.habittracker.applyKotlinLibraryConfig
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.the

class KotlinLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        val libs = the<LibrariesForLibs>()
        applyPlugins(libs)
        applyKotlinLibraryConfig()
    }
}

private fun Project.applyPlugins(libs: LibrariesForLibs) = with(pluginManager) {
    apply(plugin = "java-library")
    alias(libs.plugins.kotlin.jvm)
}