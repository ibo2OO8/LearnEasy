package com.ibrohimapk3.learneasy.domain.usecase.saveLevel

import com.ibrohimapk3.learneasy.domain.repository.LevelRepository

class GetLevelUseCase(private val levelRepository: LevelRepository) {
    fun getLevel(): String? {
        return levelRepository.getLevel()
    }
}