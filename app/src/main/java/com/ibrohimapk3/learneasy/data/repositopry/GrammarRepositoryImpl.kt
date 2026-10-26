package com.ibrohimapk3.learneasy.data.repositopry

import android.content.Context
import com.ibrohimapk3.learneasy.R
import com.ibrohimapk3.learneasy.data.entity.GrammarJsonModel
import com.ibrohimapk3.learneasy.data.mapper.toDomain
import com.ibrohimapk3.learneasy.domain.entity.GrammarModel
import com.ibrohimapk3.learneasy.domain.repository.GrammarRepository
import kotlinx.serialization.json.Json

class GrammarRepositoryImpl(private val context: Context) : GrammarRepository {
    fun loadItem(context: Context): List<GrammarJsonModel> {
        val id = when (levelFromOnboarding) {
            "a1" -> R.raw.grammar_a1
            "a2" -> R.raw.grammar_a1
            "b1" -> R.raw.grammar_a1
            "b2" -> R.raw.grammar_a1
            else -> {
                R.raw.grammar_a1
            }
        }
        val text = context.resources.openRawResource(id).bufferedReader().use { it.readText() }
        return Json { ignoreUnknownKeys = true }.decodeFromString(text)
    }

    override fun getAllItem(): List<GrammarModel> {
        val list = loadItem(context).map { it.toDomain() }
        return list
    }

    override fun getItemById(id: Int): GrammarModel {
        val list = loadItem(context).map { it.toDomain() }
        return list[id-1]
    }
}