package com.example.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

interface AppRoutes : NavKey

@Serializable
data object FeatureOne : AppRoutes
@Serializable
data object FeatureTwo : AppRoutes
