package com.example.feature.featureFirst.impl.di

import com.example.core.navigation.EntryProviderInstaller
import com.example.core.navigation.Navigator
import com.example.feature.featureFirst.impl.TestFeatureOneScreen
import com.example.feature.featureFirstapi.navigation.FeatureFirstNavKey
import com.example.feature.featureSecond.api.navigation.navigateToFeatureSecond
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
                TestFeatureOneScreen (
                    onLaunchFeatureSecondScreenAction = navigator::navigateToFeatureSecond
                )
            }
    }
}