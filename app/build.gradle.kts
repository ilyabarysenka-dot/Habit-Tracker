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
    implementation(projects.core.navigation)
    implementation(projects.core.ui)
    implementation(projects.wiring)

    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    //Splash Screen
    implementation(libs.androidx.core.splashscreen)
}