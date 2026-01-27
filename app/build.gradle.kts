plugins {
    alias(libs.plugins.habittracker.android.application)
    alias(libs.plugins.habittracker.application.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.example.habittracker"

    defaultConfig {
        applicationId = "com.example.habittracker"
    }
}

dependencies {
    //Modules
    implementation(projects.feature.featureFirst.api)
    implementation(projects.feature.featureFirst.impl)
    implementation(projects.feature.featureSecond.api)
    implementation(projects.feature.featureSecond.impl)
    implementation(projects.core.navigation)
    implementation(projects.core.ui)

    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    //Splash Screen
    implementation(libs.androidx.core.splashscreen)
}