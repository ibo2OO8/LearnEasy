package com.ibrohimapk3.learneasy.domain.usecase.grammar

import com.ibrohimapk3.learneasy.domain.entity.GrammarModel
import com.ibrohimapk3.learneasy.domain.repository.GrammarRepository

class GetAllItemUseCase(private val grammarRepository: GrammarRepository) {
    operator fun invoke(): List<GrammarModel> {
        return grammarRepository.getAllItem()
    }
}