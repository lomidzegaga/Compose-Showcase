package com.example.composeshowcase.split_text

import com.example.composeshowcase.core.base.BaseVm

class SplitTextFeatureVm :
    BaseVm<SplitTextFeatureConfig, SplitTextFeatureAction>() {

    override val initialConfig: SplitTextFeatureConfig
        get() = SplitTextFeatureConfig()

    override fun reduce(
        state: SplitTextFeatureConfig,
        action: SplitTextFeatureAction
    ): SplitTextFeatureConfig {
        return when (action) {
            is SplitTextFeatureAction.OnDelayChanged -> {
                state.copy(staggerDelayInMs = action.delay)
            }
        }
    }
}