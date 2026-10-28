package com.ibrohimapk3.learneasy.domain.repository

import com.ibrohimapk3.learneasy.domain.entity.LevelQuizModel

interface LevelQuizRepository {
    fun getAllItem(level: String): List<LevelQuizModel>
}