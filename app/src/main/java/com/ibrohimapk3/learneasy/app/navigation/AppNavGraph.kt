package com.ibrohimapk3.learneasy.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ibrohimapk3.learneasy.presentation.screen.alphabet.AlphabetScreen
import com.ibrohimapk3.learneasy.presentation.screen.main.HomeScreen
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.OnBoardingScreen
import com.ibrohimapk3.learneasy.presentation.screen.vocabulary.WordListScreen
import com.ibrohimapk3.learneasy.presentation.screen.vocabulary.component.WordItem

@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val startDestination = "main"
    NavHost(
        navController = navController, startDestination = startDestination,
    ) {
        composable("onBoarding") {
            OnBoardingScreen(modifier = modifier, toScreen = {
                navController.navigate("main")
            })
        }
        composable("main") {
            HomeScreen(
                userName = "name",
                onAlphabetClick = { navController.navigate("alphabet") },
                onVocabularyClick = {
                    navController.navigate("vocabulary")
                },
                onGrammarClick = {},
                onGamesClick = {},
                modifier = modifier,
            )
        }
        composable("alphabet") {
            AlphabetScreen(modifier, onBack = {
                navController.popBackStack()
            })
        }
        composable("vocabulary") {
            WordListScreen(
                modifier = modifier,
                unitTitle = "200 Слов на Уровень a1",
                words = sampleWords,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

val sampleWords = listOf(
    WordItem("1", "Cat", "Кот", "Kot"),
    WordItem("6", "Dog", "Собака", "Sobaka"),
    WordItem("2", "Dog", "Собака", "Sobaka"),
    WordItem("3", "Bird", "Птица", "Ptitsa"),
    WordItem("4", "Fish", "Рыба", "Ryba")
)