package com.ibrohimapk3.learneasy.domain.usecase.onboarding

import com.ibrohimapk3.learneasy.domain.repository.ObBoardingRepository

class IsCompletedUseCase(private val onBoardingRepository: ObBoardingRepository) {
    operator fun invoke(): Boolean {
        return onBoardingRepository.isCompleted()
    }
}