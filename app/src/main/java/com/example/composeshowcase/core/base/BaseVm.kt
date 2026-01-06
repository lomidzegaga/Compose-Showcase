package com.example.composeshowcase.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseVm<Config : ParamsConfig, Action>() : ViewModel() {

    protected abstract val initialConfig: Config

    private val _config = MutableStateFlow(initialConfig)
    val config = _config.asStateFlow()

    fun dispatch(action: Action) {
        _config.update { reduce(it, action) }
    }

    protected abstract fun reduce(state: Config, action: Action): Config
}