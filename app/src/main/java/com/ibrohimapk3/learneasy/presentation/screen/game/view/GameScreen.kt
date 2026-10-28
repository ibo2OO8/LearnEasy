package com.ibrohimapk3.learneasy.presentation.screen.game.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ibrohimapk3.learneasy.presentation.core.component.TopBar

@Composable
fun GameScreen(modifier: Modifier) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TopBar(onClick = {}, text = "Игры")

    }
}