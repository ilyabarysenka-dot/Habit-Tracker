package com.example.habittracker


import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.applyAndroidApplicationComposeConfig() = configure<BaseAppModuleExtension>{
    buildFeatures {
        compose = true
    }
}

internal fun Project.applyAndroidLibraryComposeConfig() = configure<LibraryExtension> {
    buildFeatures {
        compose = true
    }
}