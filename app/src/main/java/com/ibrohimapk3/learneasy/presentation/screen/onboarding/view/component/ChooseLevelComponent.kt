package com.ibrohimapk3.learneasy.presentation.screen.onboarding.view.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ibrohimapk3.learneasy.presentation.core.component.NavigationBtn
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.view.OnBoardingComponents
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.viewmodel.ChooseLevelViewModel
import com.ibrohimapk3.learneasy.presentation.ui.theme.SecondaryBlue
import com.ibrohimapk3.learneasy.presentation.ui.theme.TextH4
import com.ibrohimapk3.learneasy.presentation.ui.theme.ThirdlyBlue
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChooseLevelComponent(
    modifier: Modifier = Modifier,
    onNext: (OnBoardingComponents) -> Unit,
    vm: ChooseLevelViewModel = koinViewModel(),
) {
    val selectedLevel by vm.selectedLevel.collectAsStateWithLifecycle()

    ChooseLevelContent(
        modifier = modifier,
        selectedLevel = selectedLevel,
        onLevelClick = vm::selectLevel,
        onNextClick = {
            vm.saveLevel()
            onNext(OnBoardingComponents.GetName)
        },
    )
}

@Composable
private fun ChooseLevelContent(
    selectedLevel: EnglishLevel,
    onLevelClick: (EnglishLevel) -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .padding(top = 40.dp, bottom = 20.dp),
    ) {
        Text(
            text = "Какой у вас уровень английского?",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 35.sp,
        )
        Text(
            modifier = Modifier.padding(top = 18.dp, bottom = 32.dp),
            text = "Выберите вариант, который лучше всего описывает ваши навыки.",
            fontSize = 18.sp,
            color = TextH4,
            // textAlign не нужен: по умолчанию текст и так выравнивается по началу.
        )

        Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
            EnglishLevel.entries.chunked(2).forEach { rowLevels ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                ) {
                    rowLevels.forEach { level ->
                        LevelCard(
                            level = level,
                            isChecked = level == selectedLevel,
                            onClick = { onLevelClick(level) },
                        )
                    }
                }
            }
        }

        // Толкает кнопку вниз экрана.
        Spacer(modifier = Modifier.weight(1f))

        NavigationBtn(
            text = "Далее",
            click = onNextClick,
        )
    }
}

@Composable
private fun RowScope.LevelCard(
    level: EnglishLevel,
    isChecked: Boolean,
    onClick: () -> Unit,
) {
    val containerColor = if (isChecked) ThirdlyBlue else Color.White
    val borderColor = if (isChecked) SecondaryBlue else Color.Transparent

    Card(
        onClick = onClick,
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .heightIn(min = 155.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        border = BorderStroke(width = 2.dp, color = borderColor),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(3.dp),
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            // Код уровня: A1 / A2 / B1 / B2, цвет берём из enum.
            Text(
                modifier = Modifier.padding(bottom = 9.dp),
                text = level.name,
                fontSize = 24.sp,
                color = level.color,
            )
            Text(
                modifier = Modifier.padding(bottom = 2.5.dp),
                text = level.title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = level.description,
                fontSize = 16.sp,
                lineHeight = 18.sp,
            )
        }
    }
}


enum class EnglishLevel(
    val title: String,        // «Начинающий», «Средний»...
    val description: String,  // подпись под названием
    val color: Color,         // цвет кода уровня (A1, A2...)
) {

    A1("Начинающий", "Знаю только базовые слова", Color(0xFF2F6BFF)),
    A2("Элементарный", "Могу сказать пару фраз", Color(0xFFF59E0B)),
    B1("Средний", "Могу общаться в поездках", Color(0xFF22A25A)),
    B2("Выше среднего", "Свободно говорю на разные темы", Color(0xFFE5484D)),
}