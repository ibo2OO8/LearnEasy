package com.ibrohimapk3.learneasy.domain.usecase.onboarding

import com.ibrohimapk3.learneasy.domain.repository.OnBoardingRepository

class IsCompletedUseCase(private val onBoardingRepository: OnBoardingRepository) {
    operator fun invoke(): Boolean {
        return onBoardingRepository.isCompleted()
    }
}