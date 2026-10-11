package com.ibrohimapk3.learneasy.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ibrohimapk3.learneasy.presentation.screen.alphabet.AlphabetScreen
import com.ibrohimapk3.learneasy.presentation.screen.grammar.GrammarScreen
import com.ibrohimapk3.learneasy.presentation.screen.main.HomeScreen
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.OnBoardingScreen
import com.ibrohimapk3.learneasy.presentation.screen.vocabulary.view.WordListScreen

@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val startDestination = "onBoarding"
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
                onGrammarClick = {
                    navController.navigate("grammar")
                },
                onGamesClick = {},
                modifier = modifier,
            )
        }
        composable("alphabet") {
            0
            AlphabetScreen(modifier, onBack = {
                navController.popBackStack()
            })
        }
        composable("vocabulary") {
            WordListScreen(
                modifier = modifier, unitTitle = "200 Слов на Уровень a1", onBack = {
                    navController.popBackStack()
                })
        }
        composable("grammar") {
            GrammarScreen(modifier = modifier, onBack = {
                navController.popBackStack()
            }, onTopicClick = {})
        }
    }
}