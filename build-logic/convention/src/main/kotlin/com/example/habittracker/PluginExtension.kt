package com.example.habittracker

import org.gradle.api.plugins.PluginManager
import org.gradle.api.provider.Provider
import org.gradle.plugin.use.PluginDependency

internal fun PluginManager.alias(provider: Provider<PluginDependency>) {
    apply(provider.get().pluginId)
}