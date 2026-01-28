package com.example.habittracker.feature.featureSecond.api.navigation

import androidx.navigation3.runtime.NavKey
import com.example.habittracker.core.navigation.Navigator
import kotlinx.serialization.Serializable

@Serializable
data object FeatureSecondNavKey: NavKey

fun Navigator.navigateToFeatureSecond() {
    navigate(FeatureSecondNavKey)
}