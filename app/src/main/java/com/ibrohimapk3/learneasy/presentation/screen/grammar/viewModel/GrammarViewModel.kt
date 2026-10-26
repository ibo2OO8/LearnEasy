package com.ibrohimapk3.learneasy.presentation.screen.grammar.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrohimapk3.learneasy.domain.entity.GrammarModel
import com.ibrohimapk3.learneasy.domain.usecase.grammar.GetAllItemUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GrammarViewModel(
    private var getAllItemUseCase: GetAllItemUseCase
) : ViewModel() {
    private val _grammarList = MutableStateFlow<List<GrammarModel>>(emptyList())
    var grammarList: StateFlow<List<GrammarModel>> = _grammarList.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _grammarList.value = getAllItemUseCase.invoke()
        }
    }
}