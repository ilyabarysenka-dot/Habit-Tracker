plugins {
    alias(libs.plugins.habittracker.android.library)
}

android {
    namespace = "com.example.feature.featureFirst.api"
}

dependencies {
    api(projects.core.navigation)
}