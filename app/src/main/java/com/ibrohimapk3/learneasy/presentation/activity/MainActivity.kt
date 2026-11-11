package com.ibrohimapk3.learneasy.presentation.activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.ibrohimapk3.learneasy.app.navigation.AppNavGraph
import com.ibrohimapk3.learneasy.presentation.ui.theme.LearnEasyTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity() : ComponentActivity() {
    private val vm: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isCompleted = vm.isCompleted.value
        Log.d("MA1", "onCreate, restored=${savedInstanceState != null}")
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.WHITE,
                Color.WHITE
            )
        )

        WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightStatusBars = true

        setContent {
            LearnEasyTheme {
                Scaffold(containerColor = androidx.compose.ui.graphics.Color.White) { innerPadding ->
                    AppNavGraph(
                        isCompleted = isCompleted,
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(androidx.compose.ui.graphics.Color.White)
                    )
                }
            }
        }
    }
}