package com.ibrohimapk3.learneasy.domain.usecase.onboarding

import com.ibrohimapk3.learneasy.domain.repository.OnBoardingRepository

class CompleteUseCase(private val onBoardingRepository: OnBoardingRepository) {
    operator fun invoke() {
        onBoardingRepository.complete()
    }
}