package com.ibrohimapk3.learneasy.presentation.screen.onboarding.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.view.component.ChooseLevelComponent
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.view.component.GetNameComponent
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.view.component.GreetingComponent
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.view.component.LevelQuizComponent
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.view.component.WhichLevelUserHasComponent

enum class OnBoardingComponents {
    Greeting,
    WhichLevel,
    ChooseLevel,
    LevelQuiz,
    GetName,
}

@Composable
fun OnBoardingScreen(modifier: Modifier, toScreen: () -> Unit) {
    var screenState by remember { mutableStateOf(OnBoardingComponents.Greeting) }
    when (screenState) {
        OnBoardingComponents.Greeting -> GreetingComponent(
            modifier = modifier,
            nextScreen = { screenState = it })

        OnBoardingComponents.WhichLevel -> WhichLevelUserHasComponent(
            modifier = modifier,
            nextScreen = { screenState = it })

        OnBoardingComponents.ChooseLevel -> ChooseLevelComponent(
            modifier = modifier,
            nextScreen = { screenState = it })

        OnBoardingComponents.GetName -> GetNameComponent(
            modifier = modifier,
            nextScreen = { toScreen() })

        OnBoardingComponents.LevelQuiz -> LevelQuizComponent(
            modifier = modifier,
            nextScreen = { screenState = it })

        else -> {}
    }
}