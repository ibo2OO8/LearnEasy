package com.ibrohimapk3.learneasy.domain.usecase.saveLevel

import com.ibrohimapk3.learneasy.domain.repository.LevelRepository

class SaveLevelUseCase(private val levelRepository: LevelRepository) {
    fun saveLevel(level: String) {
        return levelRepository.saveLevel(level)
    }
}