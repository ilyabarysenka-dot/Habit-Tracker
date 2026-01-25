import com.example.habittracker.alias
import com.example.habittracker.androidTestImplementation
import com.example.habittracker.applyAndroidApplicationComposeConfig
import com.example.habittracker.debugImplementation
import com.example.habittracker.implementation
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

class AndroidApplicationComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        val libs = the<LibrariesForLibs>()
        applyPlugins(libs)
        applyDependencies(libs)
        applyAndroidApplicationComposeConfig()
    }
}

private fun Project.applyPlugins(libs: LibrariesForLibs) = with(pluginManager) {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

private fun Project.applyDependencies(libs: LibrariesForLibs) = dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    debugImplementation(libs.androidx.compose.ui.tooling)
}