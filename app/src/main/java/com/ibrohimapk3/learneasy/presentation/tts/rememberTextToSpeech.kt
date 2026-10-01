package com.ibrohimapk3.learneasy.presentation.tts

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import java.util.Locale

@Composable
fun rememberTextToSpeech(
    locale: Locale = Locale.ENGLISH,
    speechRate: Float = 0.8f
): (String) -> Unit {
    val context = LocalContext.current
    var tts by remember { mutableStateOf<TextToSpeech?>(null) }

    DisposableEffect(context) {
        var engine: TextToSpeech? = null
        engine = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                engine?.let {
                    val result = it.setLanguage(locale)
                    if (result != TextToSpeech.LANG_MISSING_DATA &&
                        result != TextToSpeech.LANG_NOT_SUPPORTED
                    ) {
                        it.setSpeechRate(speechRate)
                        tts = it
                    }
                }
            }
        }
        onDispose {
            engine.stop()
            engine.shutdown()
            tts = null
        }
    }

    return remember(tts) {
        { text: String ->
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "tts_id")
            Unit
        }
    }
}