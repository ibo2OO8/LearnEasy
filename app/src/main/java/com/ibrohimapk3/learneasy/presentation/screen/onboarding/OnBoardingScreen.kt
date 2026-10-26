package com.ibrohimapk3.learneasy.presentation.screen.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.component.ChooseLevelComponent
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.component.FindOutLevelComponent
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.component.GetNameComponent
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.component.GreetingComponent
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.component.WhichLevelUserHasComponent

enum class OnBoardingComponents {
    Greeting,
    WhichLevel,
    ChooseLevel,
    FindOutLevel,
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
            nextScreen = {
                screenState = it
            })

        OnBoardingComponents.ChooseLevel -> ChooseLevelComponent(
            modifier = modifier,
            nextScreen = { screenState = it })

        OnBoardingComponents.GetName -> GetNameComponent(
            modifier = modifier,
            nextScreen = { toScreen() })

        OnBoardingComponents.FindOutLevel -> FindOutLevelComponent()

        else -> {}
    }
}