plugins {
    alias(libs.plugins.habittracker.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.example.habittracker.data"
}

dependencies {
//Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}