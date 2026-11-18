package com.ibrohimapk3.learneasy.domain.usecase.vocabulary

import com.ibrohimapk3.learneasy.domain.entity.VocabularyModel
import com.ibrohimapk3.learneasy.domain.repository.VocabularyRepository

class GetAllIVocabularyUseCase(private val vocabularyRepository: VocabularyRepository) {
    operator fun invoke(level : String): List<VocabularyModel> {
        return vocabularyRepository.getAllItem(level)
    }
}