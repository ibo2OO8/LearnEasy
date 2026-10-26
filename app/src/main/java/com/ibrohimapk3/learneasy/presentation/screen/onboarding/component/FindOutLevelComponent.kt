package com.ibrohimapk3.learneasy.presentation.screen.onboarding.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.presentation.ui.theme.GreyBorder
import com.ibrohimapk3.learneasy.presentation.ui.theme.PrimaryGrey
import com.ibrohimapk3.learneasy.presentation.ui.theme.SecondaryBlue
import com.ibrohimapk3.learneasy.presentation.ui.theme.TextH4

private val ScreenBackground = Color(0xFFFAF9F6)
private val SecondaryBlueDark = Color(0xFF00467C)

@Composable
fun FindOutLevelComponent(
    modifier: Modifier = Modifier,
    currentQuestion: Int = 3,
    totalQuestions: Int = 12,
    title: String = "Как переводится слово?",
    subtitle: String = "Выбери один вариант ответа.",
    languagePair: String = "АНГЛИЙСКИЙ → РУССКИЙ",
    word: String = "discover",
    options: List<String> = listOf("Забывать", "Обнаруживать", "Объяснять", "Сомневаться"),
    initialSelected: Int = 1,
    onContinue: (Int) -> Unit = {},
    onDontKnow: () -> Unit = {},
) {
    var selected by remember { mutableIntStateOf(initialSelected) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            // Прогресс
            Text(
                text = "Вопрос $currentQuestion из $totalQuestions",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = TextH4,
            )
            Box(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(CircleShape)
                    .background(PrimaryGrey)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(currentQuestion / totalQuestions.toFloat())
                        .height(6.dp)
                        .clip(CircleShape)
                        .background(SecondaryBlue)
                )
            }

            // Заголовок
            Text(
                text = title,
                modifier = Modifier.padding(top = 24.dp),
                fontSize = 28.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF1A1A1A),
            )
            Text(
                text = subtitle,
                modifier = Modifier.padding(top = 8.dp),
                fontSize = 14.sp,
                color = TextH4,
            )

            // Карточка со словом
            Column(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .border(1.dp, PrimaryGrey, RoundedCornerShape(16.dp))
                    .padding(vertical = 28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = languagePair,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.8.sp,
                    color = GreyBorder,
                )
                Text(
                    text = word,
                    modifier = Modifier.padding(top = 10.dp),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = SecondaryBlue,
                    textAlign = TextAlign.Center,
                )
            }

            // Варианты ответа
            Column(
                modifier = Modifier.padding(top = 20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                options.forEachIndexed { index, text ->
                    AnswerOption(
                        text = text,
                        selected = index == selected,
                        onClick = { selected = index },
                    )
                }
            }
        }

        // Нижняя панель
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(ScreenBackground)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ContinueButton(
                text = "Продолжить",
                onClick = { onContinue(selected) },
            )
            Text(
                text = "Не знаю ответ",
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 4.dp)
                    .clickable(onClick = onDontKnow),
                fontSize = 14.sp,
                color = TextH4,
            )
        }
    }
}

@Composable
private fun AnswerOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val shape = RoundedCornerShape(14.dp)
    val bottomEdge = if (selected) SecondaryBlueDark else PrimaryGrey

    // Нижняя «толстая» кромка
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(bottomEdge)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 3.dp)
                .clip(shape)
                .background(if (selected) SecondaryBlue else Color.White)
                .then(
                    if (selected) Modifier
                    else Modifier.border(BorderStroke(1.dp, PrimaryGrey), shape)
                )
                .padding(horizontal = 14.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = text,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = if (selected) Color.White else Color(0xFF1A1A1A),
            )
            RadioMark(selected = selected)
        }
    }
}

@Composable
private fun RadioMark(selected: Boolean) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape)
            .background(Color.White)
            .border(
                width = 2.dp,
                color = if (selected) Color.White else PrimaryGrey,
                shape = CircleShape,
            ),
        contentAlignment = Alignment.Center,
    ) {
        if (selected) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(SecondaryBlue)
            )
        }
    }
}

@Composable
private fun ContinueButton(
    text: String,
    onClick: () -> Unit,
) {
    val shape = RoundedCornerShape(18.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(SecondaryBlueDark)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)
                .clip(shape)
                .background(SecondaryBlue)
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(16.dp),
            )
        }
    }
}