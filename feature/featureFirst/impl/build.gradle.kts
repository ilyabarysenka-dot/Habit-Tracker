plugins {
    alias(libs.plugins.habittracker.android.library)
    alias(libs.plugins.habittracker.library.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.example.habittracker.feature.featureFirst.impl"
}

dependencies {
    api(projects.core.navigation)
    implementation(projects.core.common)
    implementation(projects.core.ui)
    implementation(projects.core.notification)
    implementation(projects.feature.featureFirst.api)
    implementation(projects.feature.featureSecond.api)

    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.hilt.navigation)
}