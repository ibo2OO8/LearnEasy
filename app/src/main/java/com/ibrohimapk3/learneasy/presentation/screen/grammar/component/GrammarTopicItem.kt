package com.ibrohimapk3.learneasy.presentation.screen.grammar.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.domain.entity.GrammarTopic
import com.ibrohimapk3.learneasy.presentation.ui.theme.PrimaryBlue
import com.ibrohimapk3.learneasy.presentation.ui.theme.SecondaryBlue
import com.ibrohimapk3.learneasy.presentation.ui.theme.TextH4

@Composable
fun GrammarTopicItem(
    topic: GrammarTopic,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Верхняя строка: Название темы и Уровень (A1, A2 и т.д.)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = topic.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = SecondaryBlue,
                    modifier = Modifier.weight(1f)
                )
            }


            // Контент (описание)
            Text(
                text = topic.content,
                fontSize = 14.sp,
                color = TextH4
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Иконка стрелочки вправо внизу карточки
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Go to topic",
                    tint = PrimaryBlue
                )
            }
        }
    }
}