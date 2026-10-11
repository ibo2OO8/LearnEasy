package com.ibrohimapk3.learneasy.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class VocabularyJsonModel(
    var id: Int,
    var english: String,
    var russian: String,
    var level: String,
    var category: String,
    var example: String
)