package com.ibrohimapk3.learneasy.data.mapper

import com.ibrohimapk3.learneasy.data.entity.GrammarJsonModel
import com.ibrohimapk3.learneasy.data.entity.VocabularyJsonModel
import com.ibrohimapk3.learneasy.domain.entity.GrammarModel
import com.ibrohimapk3.learneasy.domain.entity.VocabularyModel

fun VocabularyJsonModel.toDomain() = VocabularyModel(
    id = id,
    english = english,
    russian = russian,
    level = level,
    example = example
)

fun GrammarJsonModel.toDomain() = GrammarModel(
    id = id,
    title = title,
    level = level,
    explanation = explanation,
    formula = formula,
    examples = examples,
)