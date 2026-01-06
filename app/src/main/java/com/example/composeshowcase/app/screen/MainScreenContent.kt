package com.example.composeshowcase.app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeshowcase.ComposeSamples

@Composable
fun MainScreenContent(
    onItemClick: (ComposeSamples) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .safeContentPadding()
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White, fontSize = 30.sp)) {
                    append("Jetpack Compose")
                }
                withStyle(style = SpanStyle(color = Color.Green, fontSize = 40.sp)) {
                    append("\n Showcase")
                }
            }
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(top = 12.dp)
        ) {
            items(ComposeSamples.entries) { item ->
                MainScreenSingleItem(item = item, onItemClick = onItemClick)
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenContentPrev() {
    MainScreenContent { }
}