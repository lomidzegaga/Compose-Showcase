package com.example.composeshowcase.features.split_text

import com.example.composeshowcase.core.base.ParamsConfig

data class SplitTextFeatureConfig(
    val staggerDelayInMs: Int = 100,
    val headline: String = "Split Text"
) : ParamsConfig
