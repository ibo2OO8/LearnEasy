package com.ibrohimapk3.learneasy.domain.repository

import com.ibrohimapk3.learneasy.domain.entity.VocabularyModel

interface VocabularyRepository {



    fun getAllItem(level: String): List<VocabularyModel>

    fun getVocabularyExample(id: String): String
}


