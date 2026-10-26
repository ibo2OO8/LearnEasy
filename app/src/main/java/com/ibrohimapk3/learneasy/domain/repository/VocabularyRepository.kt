package com.ibrohimapk3.learneasy.domain.repository

import com.ibrohimapk3.learneasy.domain.entity.VocabularyModel

interface VocabularyRepository {

    fun insertVocabulary(item: VocabularyModel)

    fun getAllItem(): List<VocabularyModel>

    fun getVocabularyExample(id: String): String
}


