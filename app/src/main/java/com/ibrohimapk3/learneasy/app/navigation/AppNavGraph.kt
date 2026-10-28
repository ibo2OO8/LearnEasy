package com.ibrohimapk3.learneasy.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ibrohimapk3.learneasy.presentation.screen.alphabet.AlphabetScreen
import com.ibrohimapk3.learneasy.presentation.screen.grammar.view.GrammarItemScreen
import com.ibrohimapk3.learneasy.presentation.screen.grammar.view.GrammarScreen
import com.ibrohimapk3.learneasy.presentation.screen.main.HomeScreen
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.view.OnBoardingScreen
import com.ibrohimapk3.learneasy.presentation.screen.vocabulary.view.WordListScreen

private fun NavHostController.navigateReplacing(route: String) {
    val current = currentBackStackEntry?.destination?.route
    navigate(route) {
        if (current != null) {
            popUpTo(current) { inclusive = true }
        }
        launchSingleTop = true
    }
}

@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val startDestination = "onBoarding"

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {

        composable("onBoarding") {
            OnBoardingScreen(
                modifier = modifier, toScreen = { navController.navigateReplacing("main") })
        }

        composable("main") {
            HomeScreen(
                userName = "name",
                onAlphabetClick = { navController.navigateReplacing("alphabet") },
                onVocabularyClick = { navController.navigateReplacing("vocabulary") },
                onGrammarClick = { navController.navigateReplacing("grammar") },
                onGamesClick = {},
                modifier = modifier,
            )
        }

        composable("alphabet") {
            AlphabetScreen(
                modifier = modifier, onBack = { navController.navigateReplacing("main") })
        }

        composable("vocabulary") {
            WordListScreen(
                modifier = modifier,
                unitTitle = "200 Слов на Уровень a1",
                onBack = { navController.navigateReplacing("main") })
        }

        composable("grammar") {
            GrammarScreen(
                modifier = modifier,
                onBack = { navController.navigateReplacing("main") },
                onTopicClick = { id ->
                    navController.navigateReplacing("grammar_item/$id")
                })
        }

        composable("grammar_item/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()

            if (id != null) {
                GrammarItemScreen(
                    modifier = modifier,
                    id = id,
                    onBack = { navController.navigateReplacing("grammar") })
            }
        }
    }
}