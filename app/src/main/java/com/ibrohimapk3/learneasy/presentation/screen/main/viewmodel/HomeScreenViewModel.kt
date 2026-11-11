package com.ibrohimapk3.learneasy.presentation.screen.main.viewmodel

import androidx.lifecycle.ViewModel
import com.ibrohimapk3.learneasy.domain.usecase.onboarding.CompleteUseCase

class HomeScreenViewModel(private val completedUseCase: CompleteUseCase) : ViewModel() {
    private fun complete() {
        completedUseCase.invoke()
    }

    init {
        complete()
    }
}
