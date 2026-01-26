package com.example.core.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.habittracker.feature.feature_one.presentation.TestFeatureOneFirstScreen
import com.example.habittracker.feature.feature_two.presentation.TestFeatureTwoFirstScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: AppRoutes = FeatureOne
) {

    val backStack = rememberNavBackStack(startDestination)

    Scaffold(modifier = modifier) { paddingValues ->
        NavDisplay(
            modifier = modifier.fillMaxSize().padding(paddingValues),
            backStack = backStack,
            entryProvider = entryProvider {
                entry<FeatureOne> { _ ->
                    TestFeatureOneFirstScreen(
                        onLaunchFeatureTwoFirstScreenAction = {
                            backStack.add(FeatureTwo)
                        }
                    )
                }
                entry<FeatureTwo> { _ ->
                    TestFeatureTwoFirstScreen(
                        onGoBackAction = {
                            backStack.remove(FeatureTwo)
                        }
                    )
                }
            }
        )
    }
}