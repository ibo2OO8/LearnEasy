package com.ibrohimapk3.learneasy.data.repository

import android.content.Context
import com.ibrohimapk3.learneasy.R
import com.ibrohimapk3.learneasy.data.entity.GrammarJsonModel
import com.ibrohimapk3.learneasy.data.mapper.toDomain
import com.ibrohimapk3.learneasy.domain.entity.GrammarModel
import com.ibrohimapk3.learneasy.domain.repository.GrammarRepository
import kotlinx.serialization.json.Json

class GrammarRepositoryImpl(private val context: Context) : GrammarRepository {
    fun loadItem(context: Context, level: String): List<GrammarJsonModel> {
        val id = when (level) {

            "A1" -> R.raw.grammar_a1
            "A2" -> R.raw.grammar_a2
            "B1" -> R.raw.grammar_b1
            "B2" -> R.raw.grammar_b2
            else -> {
                R.raw.grammar_b2
            }
        }
        val text = context.resources.openRawResource(id).bufferedReader().use { it.readText() }

        return Json { ignoreUnknownKeys = true }.decodeFromString(text)

    }

    override fun getAllItem(level: String): List<GrammarModel> {
        val list = loadItem(context, level).map { it.toDomain() }
        return list
    }

    override fun getItemById(id: Int, level: String): GrammarModel {
        val list = loadItem(context, level).map { it.toDomain() }
        return list[id - 1]
    }
}