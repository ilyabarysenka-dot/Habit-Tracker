package com.example.feature.featureSecond.impl.di

import com.example.core.navigation.EntryProviderInstaller
import com.example.core.navigation.Navigator
import com.example.feature.featureSecond.api.navigation.FeatureSecondNavKey
import com.example.feature.featureSecond.impl.TestFeatureTwoScreen
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ActivityRetainedComponent::class)
object FeatureSecondModule {

    @IntoSet
    @Provides
    fun provideEntryProviderInstaller(navigator: Navigator): EntryProviderInstaller = {
            entry<FeatureSecondNavKey> {
                TestFeatureTwoScreen(
                    onBackAction = {
                        navigator.goBack()
                    }
                )
            }
    }
}