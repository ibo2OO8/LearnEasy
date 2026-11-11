package com.ibrohimapk3.learneasy.presentation.activity

import androidx.lifecycle.ViewModel
import com.ibrohimapk3.learneasy.domain.usecase.onboarding.IsCompletedUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainActivityViewModel(
    private val isCompletedUseCase: IsCompletedUseCase,

    ) : ViewModel() {
    private val _isCompleted = MutableStateFlow<Boolean>(false)
    var isCompleted = _isCompleted.asStateFlow()

    init {
        isCompleted()
    }

    private fun isCompleted() {
        _isCompleted.value = isCompletedUseCase.invoke()
    }

}