package com.ibrohimapk3.learneasy.presentation.screen.grammar.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ibrohimapk3.learneasy.presentation.core.component.TopBar
import com.ibrohimapk3.learneasy.presentation.screen.grammar.view.component.GrammarTopicCard
import com.ibrohimapk3.learneasy.presentation.screen.grammar.view.component.HeaderSection
import com.ibrohimapk3.learneasy.presentation.screen.grammar.viewModel.GrammarViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun GrammarScreen(
    modifier: Modifier,
    onTopicClick: (Int) -> Unit,
    onBack: () -> Unit,
    viewModel: GrammarViewModel = koinViewModel()
) {
    var isEnabled by remember { mutableStateOf(true) }
    val vmList = viewModel.grammarList.collectAsState()

    Column(modifier = modifier) {
        TopBar(
            onClick = onBack,
            text = "Грамматика"
        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(vertical = 3.dp)
            ) {
                item {
                    HeaderSection()
                }

                items(vmList.value, key = { it.id }) { topic ->
                    GrammarTopicCard(
                        topic = topic,
                        onClick = {
                            if (isEnabled) {
                                isEnabled = false
                                onTopicClick(topic.id)
                            }
                        }
                    )
                }
            }
        }
    }
}