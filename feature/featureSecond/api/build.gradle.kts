plugins {
    alias(libs.plugins.habittracker.android.library)
}

android {
    namespace = "com.example.feature.featureSecond.api"
}

dependencies {
    api(projects.core.navigation)
}