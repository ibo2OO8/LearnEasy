package com.ibrohimapk3.learneasy.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.ibrohimapk3.learneasy.app.navigation.AppNavGraph
import com.ibrohimapk3.learneasy.presentation.ui.theme.LearnEasyTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.WHITE,
                android.graphics.Color.WHITE
            )
        )

        WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightStatusBars = true

        setContent {
            LearnEasyTheme {
                Scaffold(
                    containerColor = Color.White
                ) { innerPadding ->
                    AppNavGraph(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color.White)
                    )
                }
            }
        }
    }
}