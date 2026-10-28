package com.ibrohimapk3.learneasy.presentation.screen.onboarding.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.presentation.core.component.CustomIndicator
import com.ibrohimapk3.learneasy.presentation.core.component.NavigationBtn
import com.ibrohimapk3.learneasy.presentation.core.component.QuizOptionList
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.view.OnBoardingComponents
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.view_model.LevelQuizViewModel
import com.ibrohimapk3.learneasy.presentation.ui.theme.SecondaryGreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun LevelQuizComponent(
    modifier: Modifier = Modifier,
    viewModel: LevelQuizViewModel = koinViewModel(),
    nextScreen: (OnBoardingComponents) -> Unit
) {
    val list by viewModel.list.collectAsState()
    val level by viewModel.level.collectAsState()
    val levelIndex by viewModel.levelIndex.collectAsState()
    val trueAnswer by viewModel.trueAnswer.collectAsState()
    val progressIndex by viewModel.progress.collectAsState()
    val showResult by viewModel.showResult.collectAsState()
    val isPassed by viewModel.isPassed.collectAsState()

    var selected by remember {
        mutableStateOf<String?>(null)
    }

    val question = list.getOrNull(levelIndex)
    val errors = list.size - trueAnswer

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Проверка уровня ${level.uppercase()}",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        CustomIndicator(progress = progressIndex)

        Spacer(modifier = Modifier.height(15.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = SecondaryGreen
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (showResult) {
                    Text(
                        text = if (isPassed) {
                            "Отличный результат! 🎉"
                        } else {
                            "Есть над чем поработать 💪"
                        }, fontSize = 23.sp, fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Правильных ответов: $trueAnswer из ${list.size}", fontSize = 18.sp
                    )

                    Text(
                        text = "Ошибок: $errors", fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = if (isPassed) {
                            "Вы можете перейти на следующий уровень!"
                        } else {
                            "Пока рано переходить дальше. Попробуйте ещё раз!"
                        }, fontSize = 16.sp
                    )
                } else {
                    Text(
                        text = question?.question ?: "Загрузка вопросов...",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        if (!showResult) {
            QuizOptionList(
                options = question?.options ?: emptyList(),
                selectedOption = selected,
                onOptionSelected = {
                    selected = it
                })
        }

        Spacer(modifier = Modifier.weight(1f))

        NavigationBtn(
            click = {
                if (showResult) {
                    if (isPassed) {
                        viewModel.continueToNextLevel()
                    } else {
                        nextScreen(OnBoardingComponents.GetName)
                    }

                    selected = null
                } else {
                    viewModel.checkAnswer(selected)
                    selected = null
                }
            },
            text = when {
                !showResult -> "Проверить"
                isPassed -> "Перейти дальше"
                else -> "Начать изучение"
            }
        )
    }
}
