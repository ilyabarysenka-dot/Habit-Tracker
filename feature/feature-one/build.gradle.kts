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
    implementation(projects.core.common)
    implementation(projects.core.ui)
    implementation(projects.core.notification)

    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}