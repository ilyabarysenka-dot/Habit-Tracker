import com.example.habittracker.alias
import com.example.habittracker.androidTestImplementation
import com.example.habittracker.applyAndroidLibraryConfig
import com.example.habittracker.implementation
import com.example.habittracker.testImplementation
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        val libs = target.the<LibrariesForLibs>()
        applyPlugins(libs)
        applyDependencies(libs)
        applyAndroidLibraryConfig()
    }
}

private fun Project.applyPlugins(libs: LibrariesForLibs) = with(pluginManager) {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

private fun Project.applyDependencies(libs: LibrariesForLibs) = dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}


