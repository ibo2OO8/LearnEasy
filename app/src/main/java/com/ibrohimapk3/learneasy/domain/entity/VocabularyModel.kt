package com.ibrohimapk3.learneasy.domain.entity

data class VocabularyModel(
    val id: Int, val english: String, val tajik: String, var level: String, val example: String
)