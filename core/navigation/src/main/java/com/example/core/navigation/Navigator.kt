package com.example.core.navigation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import dagger.hilt.android.scopes.ActivityRetainedScoped

/**
 * An type, which is a function that feature modules use to contribute their navigation entries
 * to the application's entryProvider.
 */
typealias EntryProviderInstaller = EntryProviderScope<NavKey>.() -> Unit

/**
 * A class that manages the back stack.
 */
@ActivityRetainedScoped
class Navigator(startDestination: NavKey){

    val backStack : SnapshotStateList<NavKey> = mutableStateListOf(startDestination)

    fun navigate(route: NavKey){
        backStack.add(route)
    }

    fun goBack(){
        backStack.removeLastOrNull()
    }
}