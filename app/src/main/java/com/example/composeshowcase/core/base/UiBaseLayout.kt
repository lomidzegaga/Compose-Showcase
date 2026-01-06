package com.example.composeshowcase.core.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeshowcase.core.base.components.Headline
import com.example.composeshowcase.core.base.components.UiText

@Composable
fun <Config : ParamsConfig> UiBaseLayout(
    headline: String,
    config: Config,
    content: @Composable (Config) -> Unit,
    controls: @Composable (Config) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            UiText(text = headline, type = Headline())
        },
        floatingActionButton = {
            Text("CODE") // TODO
        },
        contentColor = Color.White,
        containerColor = Color.Black,
        modifier = modifier
            .background(color = Color.Black)
            .safeContentPadding()
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f),
                contentAlignment = Alignment.Center
            ) {
                content(config)
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item { controls(config) }
            }
        }
    }
}