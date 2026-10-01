package com.ibrohimapk3.learneasy.presentation.screen.vocabulary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.presentation.core.component.TopBar
import com.ibrohimapk3.learneasy.presentation.screen.vocabulary.component.WordCard
import com.ibrohimapk3.learneasy.presentation.screen.vocabulary.component.WordItem
import com.ibrohimapk3.learneasy.presentation.tts.rememberTextToSpeech

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WordListScreen(
    modifier: Modifier = Modifier,
    unitTitle: String,
    words: List<WordItem>,
    onBack: () -> Unit,
) {

    val speak = rememberTextToSpeech()
    Column(modifier = modifier.fillMaxSize()) {
        TopBar(onClick = {

            onBack()

        }, text = "Словарь")
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 15.dp)
                            .align(alignment = Alignment.CenterStart),
                        text = unitTitle,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                    )
                }
            }
            items(
                items = words,
                key = { word -> word.id }
            ) { word ->
                WordCard(
                    word = word,
                    onAudioClick = { speak(word.english) }
                )
            }
        }
    }
}