package com.ibrohimapk3.learneasy.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class LevelQuizJsonModel(
    val id: Int,
    val level: String,
    val question: String,
    val options: List<String>,
    val answer: String
)