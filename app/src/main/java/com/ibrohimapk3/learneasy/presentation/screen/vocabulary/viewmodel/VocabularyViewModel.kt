package com.ibrohimapk3.learneasy.presentation.screen.vocabulary.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrohimapk3.learneasy.domain.entity.VocabularyModel
import com.ibrohimapk3.learneasy.domain.usecase.saveLevel.GetLevelUseCase
import com.ibrohimapk3.learneasy.domain.usecase.vocabulary.GetAllIVocabularyUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VocabularyViewModel(
    private val getAllIVocabularyUseCase: GetAllIVocabularyUseCase,
    private var getLevelUseCase: GetLevelUseCase
) : ViewModel() {
    private val _vocabularyList = MutableStateFlow<List<VocabularyModel>>(emptyList())
    val vocabularyList: StateFlow<List<VocabularyModel>> = _vocabularyList.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            var level: String? = "b1"
            try {
                level = getLevelUseCase.getLevel()
            } catch (e: Exception) {
            }
            _vocabularyList.value = getAllIVocabularyUseCase.invoke(level.toString())
        }
    }
}