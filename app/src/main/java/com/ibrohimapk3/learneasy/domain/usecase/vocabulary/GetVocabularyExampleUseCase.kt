package com.ibrohimapk3.learneasy.domain.usecase.vocabulary

import com.ibrohimapk3.learneasy.domain.repository.VocabularyRepository

class GetVocabularyExampleUseCase(private val vocabularyRepository: VocabularyRepository) {
    operator fun invoke(id: String): String {
        return vocabularyRepository.getVocabularyExample(id)
    }
}