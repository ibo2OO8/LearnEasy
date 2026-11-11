package com.ibrohimapk3.learneasy.data.preferences

import android.content.Context
import androidx.core.content.edit

class AppPreferences(context: Context) {
    private val prefs = context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
    fun isOnboardingCompleted(): Boolean {
        return prefs.getBoolean("onBoarding_completed", false)
    }

    fun completeOnboarding() {
        prefs.edit {
            putBoolean("onBoarding_completed", true).apply()
        }
    }
}