package com.ibrohimapk3.learneasy.presentation.screen.grammar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ibrohimapk3.learneasy.domain.entity.GrammarTopic
import com.ibrohimapk3.learneasy.presentation.core.component.TopBar
import com.ibrohimapk3.learneasy.presentation.screen.grammar.component.GrammarTopicItem
import com.ibrohimapk3.learneasy.presentation.screen.grammar.component.HeaderSection

val sampleTopics = listOf(
    GrammarTopic(
        name = "Verb \"to be\"", level = "A1", content = "Am, is, are basics"
    ), GrammarTopic(
        name = "Present Simple", level = "A2", content = "Daily routines & habits"
    ), GrammarTopic(
        name = "Nouns & Plurals", level = "A1", content = "Dogs, cats, boxes"
    )
)

@Composable
fun GrammarScreen(
    modifier: Modifier,
    topics: List<GrammarTopic> = sampleTopics,
    onTopicClick: (GrammarTopic) -> Unit,
    onBack: () -> Unit
) {
    Column(modifier = modifier) {
        TopBar(onClick = { onBack() }, text = "Грамматика")

        Surface(
            modifier = Modifier.fillMaxSize(), color = Color.White // Белый фон экрана по требованию
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(vertical = 3.dp)
            ) {
                // Заголовок экрана
                item {
                    HeaderSection()
                }

                // Список элементов
                items(topics) { topic ->
                    GrammarTopicItem(
                        topic = topic, onClick = { onTopicClick(topic) })
                }
            }
        }
    }

}