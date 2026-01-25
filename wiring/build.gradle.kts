plugins {
    alias(libs.plugins.habittracker.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.example.habittracker.wiring"
}

dependencies {
    implementation(projects.data)
    implementation(projects.feature.featureOne)

    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}