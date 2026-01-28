plugins {
    alias(libs.plugins.habittracker.android.library)
}

android {
    namespace = "com.example.habittracker.feature.featureFirst.api"
}

dependencies {
    api(projects.core.navigation)
}