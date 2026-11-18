package com.ibrohimapk3.learneasy.presentation.screen.grammar.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrohimapk3.learneasy.domain.entity.GrammarModel
import com.ibrohimapk3.learneasy.domain.usecase.grammar.GetItemByIdUseCase
import com.ibrohimapk3.learneasy.domain.usecase.saveLevel.GetLevelUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class GrammarItemViewModel(
    private val grammarItemByIdUseCase: GetItemByIdUseCase,
    private var getLevelUseCase: GetLevelUseCase
) : ViewModel() {
    private val _item = MutableStateFlow<GrammarModel?>(null)
    var item = _item.asStateFlow()

    fun loadItem(id: Int) {
        viewModelScope.launch {
            var level: String? = "b1"
            try {
                level = getLevelUseCase.getLevel()
            } catch (e: Exception) { }
            _item.value = grammarItemByIdUseCase(id, level.toString())
        }
    }
}