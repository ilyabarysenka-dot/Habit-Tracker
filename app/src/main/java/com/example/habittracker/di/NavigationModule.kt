package com.example.habittracker.di

import com.example.habittracker.core.navigation.Navigator
import com.example.habittracker.feature.featureFirst.api.navigation.FeatureFirstNavKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object NavigationModule {
    @Provides
    @ActivityRetainedScoped
    fun provideNavigator() : Navigator = Navigator(startDestination = FeatureFirstNavKey)
}