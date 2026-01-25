plugins {
    alias(libs.plugins.habittracker.android.library)
    alias(libs.plugins.habittracker.library.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.example.feature.feature_one"
}

dependencies {
    api(projects.core.common)
    api(projects.core.ui)
    implementation(projects.core.notification)

    //Navigation
    implementation(libs.navigation3.runtime)
    implementation(libs.navigation3.ui)
    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}