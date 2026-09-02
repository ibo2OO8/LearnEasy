package com.ibrohimapk3.learneasy.domain.usecase.onboarding

import com.ibrohimapk3.learneasy.domain.repository.ObBoardingRepository

class CompleteUseCase(private val obBoardingRepository: ObBoardingRepository) {
    operator fun invoke() {
        obBoardingRepository.complete()
    }
}