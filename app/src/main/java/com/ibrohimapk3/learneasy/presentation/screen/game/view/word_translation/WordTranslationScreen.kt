package com.ibrohimapk3.learneasy.presentation.screen.game.view.word_translation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    modifier: Modifier, viewModel: WordTranslationViewModel = koinViewModel(), onBack: () -> Unit
) {
    val list = viewModel.russianList.collectAsState()
    val correctAnswer = list.value[3]
    val sortedList = list.value.sorted()
    val answer = viewModel.answer.collectAsState()

    var process by remember { mutableFloatStateOf(0f) }

    var selectedOption by remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        TopBar(onClick = { onBack() }, text = "Игры")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            CustomIndicator(process)

            Spacer(modifier = Modifier.height(20.dp))
            Text("Переводите Слово", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(33.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFD6E5FF))
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.VolumeUp,
                            contentDescription = "Play sound",
                            tint = Color(0xFF0066B3),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                    Text(answer.value, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.height(25.dp))

            QuizOptionList(
                options = sortedList, selectedOption = selectedOption, onOptionSelected = {
                    selectedOption = it
                })

            Spacer(modifier = Modifier.weight(1f))

            NavigationBtn(text = "Проверить", click = {
                if (correctAnswer == selectedOption) {
                    process += 0.1f
                    viewModel.getItem()
                } else {
                    Log.d("LogVoca", "false")
                }
            })
        }
    }

}



