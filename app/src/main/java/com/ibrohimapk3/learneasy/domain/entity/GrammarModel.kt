package com.ibrohimapk3.learneasy.domain.entity

data class GrammarModel(
    val id: Int,
    val title: String,
    val level: String,
    val explanation: String,
    val formula: String?,
    var examples: List<String>,
)