
package com.ibrohimapk3.learneasy.presentation.screen.game.view.word_translation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.presentation.core.component.CustomIndicator
import com.ibrohimapk3.learneasy.presentation.core.component.NavigationBtn
import com.ibrohimapk3.learneasy.presentation.core.component.QuizOptionList
import com.ibrohimapk3.learneasy.presentation.core.component.TopBar
import com.ibrohimapk3.learneasy.presentation.screen.game.viewmodel.WordTranslationViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WordTranslationScreen(
    modifier: Modifier = Modifier,
    viewModel: WordTranslationViewModel = koinViewModel(),
    onBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val list by viewModel.russianList.collectAsState()
    val answer by viewModel.answer.collectAsState()

    when {
        uiState.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.material3.CircularProgressIndicator(
                    color = Color(0xFF2878E8)
                )
            }
        }

        uiState.isFinished -> {
            GameResultScreen(
                correctAnswers = uiState.correctAnswers,
                totalQuestions = uiState.totalQuestions,
                onBack = onBack,
                onRestart = viewModel::restartGame
            )
        }

        list.isEmpty() -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Недостаточно слов для игры")
            }
        }

        else -> {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color(0xFFF8FAFF))
            ) {
                TopBar(
                    onClick = onBack,
                    text = "Игры"
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.height(5.dp))

                    CustomIndicator(uiState.progress)

                    Spacer(Modifier.height(20.dp))

                    Text(
                        text = "Переводите слово",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF172554)
                    )

                    Spacer(Modifier.height(20.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        shape = RoundedCornerShape(24.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(45.dp)
                                    .background(
                                        Color(0xFFDCE8FF),
                                        RoundedCornerShape(50)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("🔊", fontSize = 22.sp)
                            }

                            Spacer(Modifier.height(12.dp))

                            Text(
                                text = answer,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF172554)
                            )
                        }
                    }

                    Spacer(Modifier.height(25.dp))

                    QuizOptionList(
                        options = list.sorted(),
                        selectedOption = uiState.selectedOption,
                        onOptionSelected = viewModel::selectOption
                    )

                    Spacer(Modifier.weight(1f))

                    NavigationBtn(
                        text = "Проверить",
                        click = viewModel::checkAnswer
                    )
                }
            }
        }
    }
}
