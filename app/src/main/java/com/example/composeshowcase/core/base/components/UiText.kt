package com.example.composeshowcase.core.base.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Interface which must be implemented by all text types
 * @property fontSize Text size
 * @property color Text color
 * @property fontWeight Text weight
 */
interface UiTextInterface {
    val fontSize: TextUnit
    val color: Color
    val fontWeight: FontWeight?
}

/**
 * [UiTextInterface] implementation for Headline type.
 */
data class Headline(
    override val fontSize: TextUnit = 25.sp,
    override val color: Color = Color.White,
    override val fontWeight: FontWeight? = FontWeight.Bold
) : UiTextInterface

/**
 * [UiTextInterface] implementation for Body type.
 */
data class Body(
    override val fontSize: TextUnit = 17.sp,
    override val color: Color = Color.White,
    override val fontWeight: FontWeight? = null
) : UiTextInterface

@Composable
fun UiText(
    text: String,
    type: UiTextInterface,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = type.fontSize,
        fontWeight = type.fontWeight,
        color = type.color,
        modifier = modifier
    )
}

@Preview
@Composable
private fun UiTextPrev() {
    Column {
        UiText(
            text = "Headline",
            type = Headline()
        )
        UiText(
            text = "Body",
            type = Body()
        )
    }
}