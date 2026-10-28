package com.ibrohimapk3.learneasy.data.repositopry

import android.content.Context
import com.ibrohimapk3.learneasy.R
import com.ibrohimapk3.learneasy.data.entity.VocabularyJsonModel
import com.ibrohimapk3.learneasy.data.mapper.toDomain
import com.ibrohimapk3.learneasy.domain.entity.VocabularyModel
import com.ibrohimapk3.learneasy.domain.repository.VocabularyRepository
import kotlinx.serialization.json.Json

var levelFromOnboarding = "b1"
class VocabularyRepositoryImpl(private val context: Context) : VocabularyRepository {
    fun loadItems(context: Context): List<VocabularyJsonModel> {
        val id = when (levelFromOnboarding) {
            "a1" -> R.raw.english_a1_vocabulary
            "a2" -> R.raw.english_a2_vocabulary
            "b1" -> R.raw.english_b1_vocabulary
            "b2" -> R.raw.english_b2_vocabulary
            else -> {
                R.raw.english_a1_vocabulary
            }
        }
        val text = context.resources.openRawResource(id).bufferedReader().use { it.readText() }
        return Json { ignoreUnknownKeys = true }.decodeFromString(text)
    }

    override fun insertVocabulary(item: VocabularyModel) {
        TODO("Not yet implemented")
    }

    override fun getAllItem(): List<VocabularyModel> {
        val list = loadItems(context).map { it.toDomain() }
        return list
    }

    override fun getVocabularyExample(id: String): String {
        TODO("Not yet implemented")
    }
}