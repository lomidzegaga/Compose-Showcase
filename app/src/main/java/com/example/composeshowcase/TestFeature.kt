package com.example.composeshowcase

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeshowcase.core.base.UiBaseLayout
import com.example.composeshowcase.core.base.BaseVm
import com.example.composeshowcase.core.base.ParamsConfig

@Composable
fun TestFeature(
    viewModel: TestFeatureVm = viewModel()
) {
    val config = viewModel.config.collectAsState().value
    UiBaseLayout(
        headline = "Headline text here",
        config = config,
        controls = { params ->
            with(viewModel) {
                Text(
                    text = "Enabled: ${params.isEnabled}",
                    modifier = Modifier.clickable {
                        dispatch(TestFeatureAction.IsEnabled(!params.isEnabled))
                    }
                )
            }
        },
        content = { config ->
            // AnimatedText
            Text("isEnabled: ${config.isEnabled}")
        }
    )
}

@Preview
@Composable
private fun TestFeatureRootPrev() {
    TestFeature()
}

data class TestFeatureConfig(
    val isEnabled: Boolean = true
) : ParamsConfig

sealed interface TestFeatureAction {
    data class IsEnabled(val isEnabled: Boolean) : TestFeatureAction
}

class TestFeatureVm : BaseVm<TestFeatureConfig, TestFeatureAction>() {
    override val initialConfig: TestFeatureConfig
        get() = TestFeatureConfig()


    override fun reduce(
        state: TestFeatureConfig,
        action: TestFeatureAction
    ): TestFeatureConfig {
        return when (action) {
            is TestFeatureAction.IsEnabled -> {
                state.copy(isEnabled = action.isEnabled)
            }
        }
    }
}