package com.example.habittracker.feature.featureFirst.impl.di

import com.example.habittracker.feature.featureFirst.impl.TestFeatureOneScreen
import com.example.habittracker.feature.featureFirst.api.navigation.FeatureFirstNavKey
import com.example.habittracker.core.navigation.EntryProviderInstaller
import com.example.habittracker.core.navigation.Navigator
import com.example.habittracker.feature.featureSecond.api.navigation.navigateToFeatureSecond
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ActivityRetainedComponent::class)
object FeatureFirstModule {

    @IntoSet
    @Provides
    fun provideEntryProviderInstaller(navigator: Navigator): EntryProviderInstaller = {
            entry<FeatureFirstNavKey> {
                TestFeatureOneScreen(
                    onLaunchFeatureSecondScreenAction = navigator::navigateToFeatureSecond
                )
            }
    }
}