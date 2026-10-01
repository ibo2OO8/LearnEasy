package com.ibrohimapk3.learneasy.presentation.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Rule
import androidx.compose.material.icons.filled.SortByAlpha
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ibrohimapk3.learneasy.presentation.screen.main.component.GreetingHeader
import com.ibrohimapk3.learneasy.presentation.screen.main.component.MenuButtonCard
import com.ibrohimapk3.learneasy.presentation.ui.theme.GrammarFon
import com.ibrohimapk3.learneasy.presentation.ui.theme.PlaysFon
import com.ibrohimapk3.learneasy.presentation.ui.theme.SecondaryBlue
import com.ibrohimapk3.learneasy.presentation.ui.theme.VocabularyFon

@Composable
fun HomeScreen(
    userName: String,
    onAlphabetClick: () -> Unit,
    onVocabularyClick: () -> Unit,
    onGrammarClick: () -> Unit,
    onGamesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        GreetingHeader(userName = userName)

        //  DailyGoalCard()

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            MenuButtonCard(
                label = "Алфавит",
                icon = Icons.Default.SortByAlpha,
                backgroundColor = SecondaryBlue,
                contentColor = Color.White,
                onClick = onAlphabetClick,
                modifier = Modifier.weight(1f)
            )
            MenuButtonCard(
                label = "Словарь",
                icon = Icons.AutoMirrored.Filled.MenuBook,
                backgroundColor = VocabularyFon,
                contentColor = Color(0xFF3D2600),
                onClick = onVocabularyClick,
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            MenuButtonCard(
                label = "Грамматика",
                icon = Icons.Default.Rule,
                backgroundColor = GrammarFon,
                contentColor = Color.White,
                onClick = onGrammarClick,
                modifier = Modifier.weight(1f)
            )
            MenuButtonCard(
                label = "Игры",
                icon = Icons.Default.SportsEsports,
                backgroundColor = PlaysFon,
                contentColor = Color(0xFFB03A48),
                onClick = onGamesClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
