package com.ibrohimapk3.learneasy.presentation.screen.game.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrohimapk3.learneasy.domain.entity.VocabularyModel
import com.ibrohimapk3.learneasy.domain.usecase.vocabulary.GetAllIVocabularyUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WordTranslationViewModel(
    private val getAllVocabularyUseCase: GetAllIVocabularyUseCase
) : ViewModel() {
    private val _list = MutableStateFlow<List<VocabularyModel>>(emptyList())
    val list = _list.asStateFlow()

    private var _russianList = MutableStateFlow<List<String>>(emptyList())
    val russianList = _russianList.asStateFlow()

    private val _answer = MutableStateFlow("")
    val answer = _answer.asStateFlow()

    init {
        loadData()
        getItem()
    }

    private fun loadData() {
        viewModelScope.launch {
            _list.value = getAllVocabularyUseCase.invoke()
        }
    }

    fun getItem() {
        _russianList.value = emptyList()
        _answer.value = ""
        for (i in 1..4) {
            val word = list.value.shuffled()[i]
            val english = word.english
            val russian = word.russian

            _russianList.value += russian
            _answer.value = english
        }
    }
}