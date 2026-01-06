package com.example.composeshowcase.core.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.example.composeshowcase.ComposeSamples
import com.example.composeshowcase.app.screen.MainScreenContent
import com.example.composeshowcase.features.split_text.SplitTextFeatureScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun NavigationRoot() {
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Route.ComponentsList::class, Route.ComponentsList.serializer())
                    subclass(Route.SingleComponent::class, Route.SingleComponent.serializer())
                }
            }
        },
        Route.ComponentsList
    )

    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = { key ->
            when (key) {
                is Route.ComponentsList -> {
                    NavEntry(key) {
                        MainScreenContent { item -> backStack.add(Route.SingleComponent(item)) }
                    }
                }

                is Route.SingleComponent -> {
                    NavEntry(key) {
                        when (key.item) {
                            ComposeSamples.SPLIT_TEXT -> {
                                SplitTextFeatureScreen()
                            }
                        }
                    }
                }

                else -> error("Unknown route")
            }
        }
    )
}