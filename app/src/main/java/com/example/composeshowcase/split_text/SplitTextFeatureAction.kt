package com.example.composeshowcase.split_text

sealed interface SplitTextFeatureAction {
    data class OnDelayChanged(val delay: Int) : SplitTextFeatureAction
}