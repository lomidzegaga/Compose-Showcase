package com.example.composeshowcase.features.split_text

sealed interface SplitTextFeatureAction {
    data class OnDelayChanged(val delay: Int) : SplitTextFeatureAction
}