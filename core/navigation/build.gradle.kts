plugins {
    alias(libs.plugins.habittracker.android.library)
    alias(libs.plugins.habittracker.library.compose)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.core.navigation"
}

dependencies {
    implementation(projects.feature.featureOne)
    implementation(projects.feature.featureTwo)

    //Navigation
    implementation(libs.navigation3.runtime)
    implementation(libs.navigation3.ui)
    implementation(libs.navigation3.viewModel)
    implementation(libs.kotlinx.serialization.core)
}