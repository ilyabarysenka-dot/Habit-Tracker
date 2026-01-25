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
    implementation(projects.feature.featureOne)
    implementation(projects.core.common)
    implementation(projects.core.ui)
    implementation(projects.core.notification)
    implementation(projects.data)
    implementation(projects.wiring)

    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    //Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    // Networking (Retrofit + OkHttp + JSON)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)

    //Splash Screen
    implementation(libs.androidx.core.splashscreen)

    //Navigation
    implementation(libs.navigation3.runtime)
    implementation(libs.navigation3.ui)
}