package com.ibrohimapk3.learneasy.domain.usecase.grammar

import com.ibrohimapk3.learneasy.domain.entity.GrammarModel
import com.ibrohimapk3.learneasy.domain.repository.GrammarRepository

class GetItemByIdUseCase(private val grammarRepository: GrammarRepository) {
    operator fun invoke(id: Int): GrammarModel {
        return grammarRepository.getItemById(id = id)
    }
}