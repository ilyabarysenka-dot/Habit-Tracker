import com.example.habittracker.alias
import com.example.habittracker.androidTestImplementation
import com.example.habittracker.applyAndroidApplicationConfig
import com.example.habittracker.debugImplementation
import com.example.habittracker.implementation
import com.example.habittracker.testImplementation
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

class AndroidApplicationConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        val libs = the<LibrariesForLibs>()
        applyPlugins(libs)
        applyDependencies(libs)
        applyAndroidApplicationConfig()
    }
}

private fun Project.applyPlugins(libs: LibrariesForLibs) = with(pluginManager) {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

private fun Project.applyDependencies(libs: LibrariesForLibs) = dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.material3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}