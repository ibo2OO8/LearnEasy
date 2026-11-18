package com.ibrohimapk3.learneasy.domain.repository

import com.ibrohimapk3.learneasy.domain.entity.GrammarModel

interface GrammarRepository {
    fun getAllItem(level: String): List<GrammarModel>
    fun getItemById(id: Int, levelRepository: String): GrammarModel
}