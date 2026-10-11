package com.ibrohimapk3.learneasy.presentation.screen.alphabet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.presentation.core.component.TopBar
import com.ibrohimapk3.learneasy.presentation.screen.alphabet.component.LetterCell
import com.ibrohimapk3.learneasy.presentation.screen.alphabet.component.alphabet
import com.ibrohimapk3.learneasy.presentation.tts.rememberTextToSpeech
import com.ibrohimapk3.learneasy.presentation.ui.theme.TextH4

@Composable
fun AlphabetScreen(modifier: Modifier = Modifier, onBack: () -> Unit) {
    val speak = rememberTextToSpeech()
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        TopBar(onClick = { onBack() }, text = "Алфавит")

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(12.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) { // Растягиваем на всю ширину сетки (3 колонки)
                Text(
                    text = "Давайте выучим английский алфавит!",
                    fontSize = 14.sp,
                    color = TextH4,
                    modifier = Modifier
                        .padding(start = 3.dp, bottom = 8.dp)
                        .fillMaxWidth()
                )
            }

            items(alphabet) { letter ->
                LetterCell(letter = letter, onClick = { speak(letter.toString()) })
            }
        }
    }
}