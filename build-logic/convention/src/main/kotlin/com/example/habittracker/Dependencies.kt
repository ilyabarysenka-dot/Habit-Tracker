package com.example.habittracker

import org.gradle.api.artifacts.Dependency
import org.gradle.kotlin.dsl.DependencyHandlerScope

internal fun DependencyHandlerScope.implementation(dep: Any): Dependency? =
    add("implementation", dep)

internal fun DependencyHandlerScope.ksp(dep: Any): Dependency? =
    add("ksp", dep)

internal fun DependencyHandlerScope.testImplementation(dep: Any): Dependency? =
    add("testImplementation", dep)

internal fun DependencyHandlerScope.androidTestImplementation(dep: Any): Dependency? =
    add("androidTestImplementation", dep)

internal fun DependencyHandlerScope.debugImplementation(dep: Any): Dependency? =
    add("debugImplementation", dep)
