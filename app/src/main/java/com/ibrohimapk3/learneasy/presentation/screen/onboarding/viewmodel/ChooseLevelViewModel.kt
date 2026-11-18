package com.ibrohimapk3.learneasy.presentation.screen.onboarding.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrohimapk3.learneasy.domain.usecase.saveLevel.SaveLevelUseCase
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.view.component.EnglishLevel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChooseLevelViewModel(
    private val saveLevelUseCase: SaveLevelUseCase,
) : ViewModel() {

    private val _selectedLevel = MutableStateFlow(EnglishLevel.A1)
    val selectedLevel: StateFlow<EnglishLevel> = _selectedLevel.asStateFlow()

    fun selectLevel(level: EnglishLevel) {
        _selectedLevel.value = level
    }

    fun saveLevel() {
        viewModelScope.launch {
            saveLevelUseCase.saveLevel(_selectedLevel.value.name)
        }
    }
}