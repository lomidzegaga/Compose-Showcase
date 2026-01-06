package com.example.composeshowcase.core.base.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UiSlider(
    label: String,
    defaultValue: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var value by remember { mutableIntStateOf(defaultValue) }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        UiText(
            text = label,
            type = Body(),
            modifier = Modifier.padding(end = 12.dp)
        )

        Slider(
            value = value.toFloat(),
            onValueChange = { value = it.toInt() },
            valueRange = 1f..500f,
            onValueChangeFinished = {
                onValueChange(value)
            },
            modifier = Modifier.weight(1f)
        )

        UiText(
            text = value.toString(),
            type = Body(),
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Preview
@Composable
private fun UiSliderPrev() {
    UiSlider(
        label = "test",
        defaultValue = 50,
        onValueChange = { }
    )
}