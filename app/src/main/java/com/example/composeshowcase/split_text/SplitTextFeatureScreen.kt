package com.example.composeshowcase.split_text

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeshowcase.core.base.UiBaseLayout
import com.example.composeshowcase.core.base.components.Body
import com.example.composeshowcase.core.base.components.Headline
import com.example.composeshowcase.core.base.components.UiSlider
import com.example.composeshowcase.core.base.components.UiText
import com.example.composeshowcase.core.utils.DEFAULT_TEXT
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplitTextFeatureScreen(
    viewModel: SplitTextFeatureVm = viewModel()
) {
    val config = viewModel.config.collectAsState().value
    UiBaseLayout(
        headline = config.headline,
        config = config,
        controls = { params ->
            with(viewModel) {
                Column {
                    UiSlider(
                        label = "Stagger Delay (ms)",
                        defaultValue = params.staggerDelayInMs,
                        onValueChange = {
                            dispatch(SplitTextFeatureAction.OnDelayChanged(it))
                        }
                    )
                }
            }
        },
        content = { config ->
            AnimatingText(
                delay = config.staggerDelayInMs
            )
        }
    )
}

@Composable
fun AnimatingText(
    delay: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        DEFAULT_TEXT.forEachIndexed { index, char ->
            AnimatedChar(
                char = char,
                index = index,
                delay = delay
            )
        }
    }
}

@Composable
private fun AnimatedChar(
    char: Char,
    index: Int,
    delay: Int
) {
    val offsetY = remember { Animatable(30f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(delay) {
        offsetY.snapTo(30f)
        alpha.snapTo(0f)

        delay((index * delay).toLong())

        launch {
            offsetY.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 220,
                    easing = FastOutSlowInEasing
                )
            )
        }

        launch {
            alpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = 220,
                    easing = LinearEasing
                )
            )
        }
    }

    UiText(
        text = char.toString(),
        type = Headline(),
        modifier = Modifier
            .offset(y = offsetY.value.dp)
            .alpha(alpha.value)
    )
}

@Preview
@Composable
private fun SplitTextFeatureScreenPrev() {
    SplitTextFeatureScreen()
}