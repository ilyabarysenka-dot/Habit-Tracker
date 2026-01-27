plugins {
    alias(libs.plugins.habittracker.android.library)
    alias(libs.plugins.habittracker.library.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.example.core.navigation"
}

dependencies {

    //Navigation
    implementation(libs.navigation3.runtime)
    api(libs.navigation3.ui)
    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}