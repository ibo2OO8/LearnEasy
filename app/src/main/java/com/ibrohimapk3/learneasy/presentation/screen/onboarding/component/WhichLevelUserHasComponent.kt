package com.ibrohimapk3.learneasy.presentation.screen.onboarding.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.presentation.core.component.NavigationBtn
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.OnBoardingComponents
import com.ibrohimapk3.learneasy.presentation.ui.theme.SecondaryBlue
import com.ibrohimapk3.learneasy.presentation.ui.theme.TextH4
import com.ibrohimapk3.learneasy.presentation.ui.theme.ThirdlyBlue

@Composable
fun WhichLevelUserHasComponent(modifier: Modifier, nextScreen: (OnBoardingComponents) -> Unit) {
    var isSelfStudySelected by remember { mutableStateOf(true) }
    var isTestSelected by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = "Какой у вас уровень английского?",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 35.sp,
            color = Color(0xFF212121)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Как определить уровень?",
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF212121)
        )

        Spacer(modifier = Modifier.height(14.dp))

        LevelSelectionCard(
            title = "Самостоятельно",
            description = "Выберите уровень из четырёх вариантов ниже.",
            selected = isSelfStudySelected,
            onClick = {
                isSelfStudySelected = true
                isTestSelected = false
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        LevelSelectionCard(
            title = "Пройти тест",
            description = "Ответьте на короткие вопросы, чтобы понять свой уровень.",
            selected = isTestSelected,
            onClick = {
                isSelfStudySelected = false
                isTestSelected = true
            }
        )
        Spacer(modifier = Modifier.weight(1f))

        NavigationBtn(
            text = "Далее",
            click = {
                if (isTestSelected) nextScreen(OnBoardingComponents.FindOutLevel)
                else nextScreen(OnBoardingComponents.ChooseLevel)
            },
        )
    }
}


@Composable
fun LevelSelectionCard(
    title: String,
    description: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(
            width = if (selected) 2.dp else 1.dp,
            color = if (selected) SecondaryBlue else Color(0xFFE5E5E5)
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) ThirdlyBlue else Color(0xFFFAFAFA)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (selected) 3.dp else 0.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = title,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (selected) SecondaryBlue else Color(0xFF212121)
                )

                RadioButton(
                    selected = selected,
                    onClick = onClick,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = SecondaryBlue,
                        unselectedColor = SecondaryBlue
                    )
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = description,
                fontSize = 14.sp,
                lineHeight = 21.sp,
                color = if (selected) SecondaryBlue else TextH4
            )
        }
    }
}