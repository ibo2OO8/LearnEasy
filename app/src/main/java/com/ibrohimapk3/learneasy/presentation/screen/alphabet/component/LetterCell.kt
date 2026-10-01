package com.ibrohimapk3.learneasy.presentation.screen.alphabet.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.presentation.tts.rememberTextToSpeech
import com.ibrohimapk3.learneasy.presentation.ui.theme.ConsonantColor
import com.ibrohimapk3.learneasy.presentation.ui.theme.VowelColor


val vowels = setOf('A', 'E', 'I', 'O', 'U')
val alphabet = ('A'..'Z').toList()

@Composable
fun LetterCell(letter: Char, onClick: () -> Unit) {
    val backgroundColor = if (letter in vowels) VowelColor else ConsonantColor

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .background(color = backgroundColor, shape = RoundedCornerShape(12.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = letter.toString(),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF212121)
        )
    }
}