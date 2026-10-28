package com.ibrohimapk3.learneasy.domain.entity

data class LevelQuizModel(
    val id: Int,
    val level: String,
    val question: String,
    val options: List<String>,
    val answer: String,
)