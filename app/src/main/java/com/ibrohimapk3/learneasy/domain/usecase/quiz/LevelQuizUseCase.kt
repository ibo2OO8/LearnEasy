package com.ibrohimapk3.learneasy.domain.usecase.quiz

import com.ibrohimapk3.learneasy.domain.entity.LevelQuizModel
import com.ibrohimapk3.learneasy.domain.repository.LevelQuizRepository

class LevelQuizUseCase(val repository: LevelQuizRepository) {
    operator fun invoke(level: String): List<LevelQuizModel> {
        return repository.getAllItem(level)
    }
}