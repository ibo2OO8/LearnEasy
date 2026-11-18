package com.ibrohimapk3.learneasy.presentation.screen.game.view.word_translation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.presentation.ui.theme.PrimaryBlue

@Composable
fun GameResultScreen(
    correctAnswers: Int, totalQuestions: Int, onBack: () -> Unit, onRestart: () -> Unit
) {
    val percentage = if (totalQuestions > 0) {
        correctAnswers * 100 / totalQuestions
    } else 0

    val resultText = when {
        percentage >= 90 -> "Отличный результат!"
        percentage >= 70 -> "Очень хорошо!"
        percentage >= 50 -> "Хорошая работа!"
        else -> "Продолжай тренироваться!"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFF))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.EmojiEvents,
            contentDescription = null,
            tint = PrimaryBlue,
            modifier = Modifier.size(100.dp)
        )

        Spacer(Modifier.height(25.dp))

        Text(
            text = "Игра завершена!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF172554)
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = resultText, fontSize = 17.sp, color = Color.Gray
        )

        Spacer(Modifier.height(35.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFDCE8FF)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$correctAnswers / $totalQuestions",
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlue
                )

                Text(
                    text = "Правильных ответов", color = Color(0xFF334155)
                )

                Spacer(Modifier.height(20.dp))

                Text(
                    text = "$percentage%",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlue
                )

                Text(
                    text = "Твой результат", color = Color.Gray
                )
            }
        }

        Spacer(Modifier.height(30.dp))

        Button(
            onClick = onRestart,
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryBlue
            )
        ) {
            Text("Играть снова", fontSize = 17.sp)
        }

        Spacer(Modifier.height(12.dp))

        TextButton(onClick = onBack) {
            Text(
                "Вернуться на главную", color = PrimaryBlue, fontSize = 16.sp
            )
        }
    }
}