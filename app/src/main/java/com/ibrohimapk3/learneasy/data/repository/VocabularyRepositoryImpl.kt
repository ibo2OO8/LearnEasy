package com.ibrohimapk3.learneasy.data.repository

import android.content.Context
import com.ibrohimapk3.learneasy.R
import com.ibrohimapk3.learneasy.data.entity.VocabularyJsonModel
import com.ibrohimapk3.learneasy.data.mapper.toDomain
import com.ibrohimapk3.learneasy.domain.entity.VocabularyModel
import com.ibrohimapk3.learneasy.domain.repository.VocabularyRepository
import kotlinx.serialization.json.Json

class VocabularyRepositoryImpl(private val context: Context) : VocabularyRepository {
    fun loadItems(context: Context , level:String): List<VocabularyJsonModel> {
        val id = when (level) {
            "A1" -> R.raw.english_a1_vocabulary
            "A2" -> R.raw.english_a2_vocabulary
            "B1" -> R.raw.english_b1_vocabulary
            "B2" -> R.raw.english_b2_vocabulary
            else -> {
                R.raw.english_a1_vocabulary
            }
        }
        val text = context.resources.openRawResource(id).bufferedReader().use { it.readText() }
        return Json { ignoreUnknownKeys = true }.decodeFromString(text)
    }



    override fun getAllItem(level : String): List<VocabularyModel> {
        val list = loadItems(context , level).map { it.toDomain() }
        return list
    }

    override fun getVocabularyExample(id: String): String {
        TODO("Not yet implemented")
    }
}