package com.ibrohimapk3.learneasy.presentation.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ibrohimapk3.learneasy.presentation.ui.theme.PrimaryBlue

@Composable
fun CustomIndicator(
    progress: Float, // Значение от 0f до 1f
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(Color(0xFFE0E0E0))
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth(progress.coerceIn(0f, 1f))
                .fillMaxHeight()
                .clip(RoundedCornerShape(50.dp))
                .background(PrimaryBlue)
        )
    }
}