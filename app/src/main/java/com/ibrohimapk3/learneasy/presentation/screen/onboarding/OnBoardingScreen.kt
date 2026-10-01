package com.ibrohimapk3.learneasy.presentation.screen.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.component.CheckLevelComponent
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.component.GetNameComponent
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.component.GreetingComponent

@Composable
fun OnBoardingScreen(modifier: Modifier , toScreen : ()-> Unit) {
    var screenState by remember { mutableIntStateOf(0) }
    when (screenState) {
        0 -> GreetingComponent(modifier = modifier, nextScreen = { screenState++ })
        1 -> CheckLevelComponent(modifier = modifier, nextScreen = { screenState++ })
        2 -> GetNameComponent(modifier = modifier, nextScreen = { toScreen() })
    }
}