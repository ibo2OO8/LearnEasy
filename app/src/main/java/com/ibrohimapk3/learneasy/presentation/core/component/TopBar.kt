package com.ibrohimapk3.learneasy.presentation.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.presentation.ui.theme.PrimaryBlue
import com.ibrohimapk3.learneasy.presentation.ui.theme.PrimaryGrey

@Composable
fun TopBar(onClick: () -> Unit, text: String) {
    var isEnabled by remember { mutableStateOf(true) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)

    ) {
        IconButton(
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp)
                .align(Alignment.CenterStart),
            onClick = {
                onClick()
                isEnabled = false
            },
            enabled = isEnabled
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back"
            )
        }
        Text(
            text = text,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Center),
            color = PrimaryBlue,
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.2.dp)
                .background(color = PrimaryGrey)
                .align(Alignment.BottomCenter)
                .shadow(
                    elevation = 4.dp,
                    // shape = RoundedCornerShape(12.dp)
                )
        )
    }
}