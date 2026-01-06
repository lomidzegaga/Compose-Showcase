package com.example.composeshowcase.core.navigation

import androidx.navigation3.runtime.NavKey
import com.example.composeshowcase.ComposeSamples
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route : NavKey {

    @Serializable
    data object ComponentsList : Route, NavKey

    @Serializable
    data class SingleComponent(val item: ComposeSamples) : Route, NavKey
}