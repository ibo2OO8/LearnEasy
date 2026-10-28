package com.ibrohimapk3.learneasy.data.repositopry

import android.content.Context
import com.ibrohimapk3.learneasy.R
import com.ibrohimapk3.learneasy.data.entity.LevelQuizJsonModel
import com.ibrohimapk3.learneasy.data.mapper.toDomain
import com.ibrohimapk3.learneasy.domain.entity.LevelQuizModel
import com.ibrohimapk3.learneasy.domain.repository.LevelQuizRepository
import kotlinx.serialization.json.Json
class LevelQuizRepositoryImpl(private val context: Context) : LevelQuizRepository {
    private val json = Json { ignoreUnknownKeys = true }

    private fun loadItem(level: String): List<LevelQuizJsonModel> {
        val id = when (level) {
            "a1" -> R.raw.quiz_a1
            "a2" -> R.raw.quiz_a2
            "b1" -> R.raw.quiz_b1
            "b2" -> R.raw.quiz_b2
            else -> R.raw.quiz_a1
        }
        val text = context.resources.openRawResource(id).bufferedReader().use { it.readText() }
        return json.decodeFromString<List<LevelQuizJsonModel>>(text)
    }

    override fun getAllItem(level: String): List<LevelQuizModel> =
        loadItem(level).map { it.toDomain() }
}