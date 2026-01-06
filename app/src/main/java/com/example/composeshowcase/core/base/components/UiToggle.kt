package com.example.composeshowcase.core.base.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UiToggle(
    label: String,
    isSelected: Boolean,
    onSelected: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        UiText(text = label, type = Body())
        Switch(
            checked = isSelected,
            onCheckedChange = onSelected
        )
    }
}

@Preview
@Composable
private fun UiTogglePrev() {
    UiToggle(
        label = "test",
        isSelected = true,
        onSelected = { }
    )
}