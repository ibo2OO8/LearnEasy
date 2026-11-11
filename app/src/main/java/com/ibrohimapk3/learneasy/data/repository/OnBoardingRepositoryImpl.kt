package com.ibrohimapk3.learneasy.data.repository

import com.ibrohimapk3.learneasy.data.preferences.AppPreferences
import com.ibrohimapk3.learneasy.domain.repository.OnBoardingRepository

class OnBoardingRepositoryImpl(private val appPreferences: AppPreferences) : OnBoardingRepository {
    override fun isCompleted(): Boolean {
        return appPreferences.isOnboardingCompleted()
    }

    override fun complete() {
        appPreferences.completeOnboarding()
    }
}