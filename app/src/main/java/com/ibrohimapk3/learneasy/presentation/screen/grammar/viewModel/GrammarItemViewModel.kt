package com.ibrohimapk3.learneasy.presentation.screen.grammar.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrohimapk3.learneasy.domain.entity.GrammarModel
import com.ibrohimapk3.learneasy.domain.usecase.grammar.GetItemByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class GrammarItemViewModel(
    private val grammarItemByIdUseCase: GetItemByIdUseCase
) : ViewModel() {
    private val _item = MutableStateFlow<GrammarModel?>(null)
    var item = _item.asStateFlow()

    fun loadItem(id: Int) {
        viewModelScope.launch {
            _item.value = grammarItemByIdUseCase(id)
        }
    }
}