package com.ibrohimapk3.learneasy.presentation.screen.alphabet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ibrohimapk3.learneasy.presentation.core.component.TopBar
import com.ibrohimapk3.learneasy.presentation.screen.alphabet.component.LetterCell
import com.ibrohimapk3.learneasy.presentation.screen.alphabet.component.alphabet
import com.ibrohimapk3.learneasy.presentation.tts.rememberTextToSpeech

@Composable
fun AlphabetScreen(modifier: Modifier = Modifier, onBack: () -> Unit) {

    var isEnabled by remember { mutableStateOf(true) }
    val speak = rememberTextToSpeech()
    Column(modifier = modifier.fillMaxSize()) {
        TopBar(onClick = { onBack() }, text = "Алфавит")

        Text(
            text = "Давайте выучим английский алфавит!",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(start = 15.dp)
                .align(alignment = Alignment.Start)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(12.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(alphabet) { letter ->
                LetterCell(letter = letter, onClick = { speak(letter.toString()) })
            }
        }
    }
}

