plugins {
    alias(libs.plugins.habittracker.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.example.habittracker.core.data"
}

dependencies {
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}