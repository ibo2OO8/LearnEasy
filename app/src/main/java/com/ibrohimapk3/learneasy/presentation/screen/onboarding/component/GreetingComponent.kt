package com.ibrohimapk3.learneasy.presentation.screen.onboarding.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.learneasy.R
import com.ibrohimapk3.learneasy.presentation.core.component.NavigationBtn
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.OnBoardingComponents
import com.ibrohimapk3.learneasy.presentation.ui.theme.PrimaryBlue
import com.ibrohimapk3.learneasy.presentation.ui.theme.TextH4

@Composable
fun GreetingComponent(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.icon1_onb,
    text1: String = "Добро пожаловать в мир английского!",
    text2: String = "Учись играя, шаг за шагом.",
    btnText: String = "Начать",
    nextScreen: (OnBoardingComponents) -> Unit,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6F),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(0.7F)
                    .height(430.dp),
                painter = painterResource(id = icon),
                contentDescription = ""
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = text1,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = PrimaryBlue,
                fontWeight = FontWeight.Bold,
                lineHeight = 35.sp,
            )
            Text(
                modifier = Modifier.padding(bottom = 32.dp),
                text = text2,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = TextH4
            )
            NavigationBtn(text = btnText, click = { nextScreen(OnBoardingComponents.WhichLevel) })
        }
    }
}











