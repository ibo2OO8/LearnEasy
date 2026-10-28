package com.ibrohimapk3.learneasy.presentation.screen.onboarding.view.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.presentation.core.component.NavigationBtn
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.view.OnBoardingComponents
import com.ibrohimapk3.learneasy.presentation.ui.theme.SecondaryBlue
import com.ibrohimapk3.learneasy.presentation.ui.theme.TextH4
import com.ibrohimapk3.learneasy.presentation.ui.theme.ThirdlyBlue

@Composable
fun ChooseLevelComponent(
    modifier: Modifier = Modifier,
    nextScreen: (OnBoardingComponents) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(Id.A1) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 40.dp, bottom = 20.dp),
    ) {
        Text(
            text = "Какой у вас уровень английского?",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 35.sp,
        )
        Text(
            modifier = Modifier.padding(bottom = 32.dp, top = 18.dp),
            text = "Выберите вариант, который лучше всего описывает ваши навыки.",
            textAlign = TextAlign.Left,
            fontSize = 18.sp,
            color = TextH4,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            GetLevelCard(
                levelText = Id.A1.name,
                levelText2 = "Начинающий",
                levelDescription = "Могу сказать пару фраз",
                id = Id.A1,
                isChecked = selectedIndex == Id.A1,
                click = {
                    selectedIndex = Id.A1
                }
            )
            Spacer(Modifier.width(15.dp))

            GetLevelCard(
                levelText = Id.A2.name,
                levelText2 = "Элементарный",
                levelDescription = "Могу сказать пару фраз",
                id = Id.A2,

                isChecked = selectedIndex == Id.A2,
                click = {
                    selectedIndex = Id.A2
                }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            GetLevelCard(
                levelText = Id.B1.name,
                levelText2 = "Средний",
                levelDescription = "Могу общаться в поездках",
                id = Id.B1,
                isChecked = selectedIndex == Id.B1,
                click = {
                    selectedIndex = Id.B1
                }
            )

            Spacer(Modifier.width(15.dp))

            GetLevelCard(
                levelText = Id.B2.name,
                levelText2 = "Выще среднего",
                levelDescription = "Свободно говорю на разные темы",
                id = Id.B2,
                isChecked = selectedIndex == Id.B2,
                click = {
                    selectedIndex = Id.B2
                }

            )
        }

        Spacer(modifier = Modifier.weight(1F))

        NavigationBtn(
            text = "Далее",
            click = { nextScreen(OnBoardingComponents.GetName) },
        )
    }
}

enum class Id { A1, A2, B1, B2 }

@Composable
fun RowScope.GetLevelCard(
    levelText: String,
    levelText2: String,
    levelDescription: String,
    id: Id,
    isChecked: Boolean = false,
    click: () -> Unit
) {
    var containerColor = Color.White
    var borderColor = Color.Transparent
    if (isChecked) {
        containerColor = ThirdlyBlue
        borderColor = SecondaryBlue
    }
    Card(
        modifier = Modifier
            .padding(bottom = 15.dp)
            .weight(0.1F)
            .height(155.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
        ),
        border = BorderStroke(
            width = 2.dp,
            color = borderColor
        ),
        shape = RoundedCornerShape(size = 16.dp),
        elevation = CardDefaults.cardElevation(3.dp),
        onClick = {
            click()
        }
    ) {
        val txColor = when (id) {
            Id.A1 -> Color.Blue
            Id.A2 -> Color.Yellow
            Id.B1 -> Color.Green
            Id.B2 -> Color.Red
        }
        Column(modifier = Modifier.padding(all = 15.dp)) {
            Text(
                modifier = Modifier.padding(bottom = 9.dp),
                text = levelText,
                fontSize = 24.sp,
                color = txColor
            )
            Text(
                modifier = Modifier.padding(bottom = 2.5.dp),
                text = levelText2,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                lineHeight = 18.sp,
                modifier = Modifier.padding(bottom = 7.dp),
                text = levelDescription,
                fontSize = 16.sp
            )
        }
    }
}

