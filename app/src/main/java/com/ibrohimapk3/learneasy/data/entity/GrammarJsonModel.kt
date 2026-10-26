package com.ibrohimapk3.learneasy.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class GrammarJsonModel(
    val id: Int,
    val title: String,
    val level: String, // например: "A1", "A2", "B1", "B2"
    val explanation: String,
    val formula: String?,
    var examples: List<String>,
)