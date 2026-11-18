package com.ibrohimapk3.learneasy.data.repository

import com.ibrohimapk3.learneasy.data.preferences.AppPreferences
import com.ibrohimapk3.learneasy.domain.repository.LevelRepository

class LevelRepositoryImpl(private val appPreferences: AppPreferences) : LevelRepository {
    override fun getLevel(): String? {
        return appPreferences.getLevel()
    }

    override fun saveLevel(level: String) {
        appPreferences.saveLevel(level)
    }
}