package com.ibrohimapk3.learneasy.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ibrohimapk3.learneasy.app.navigation.AppNavGraph
import com.ibrohimapk3.learneasy.presentation.ui.theme.LearnEasyTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val vm: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightStatusBars = true

        setContent {
            LearnEasyTheme {

                val isCompleted by vm.isCompleted.collectAsStateWithLifecycle()

                Scaffold(
                    containerColor = Color.White
                ) { innerPadding ->
                    Log.d("isCompleted1", isCompleted.toString())
                    AppNavGraph(
                        isCompleted = isCompleted,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
