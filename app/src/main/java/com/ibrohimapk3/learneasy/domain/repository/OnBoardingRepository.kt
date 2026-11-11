package com.ibrohimapk3.learneasy.domain.repository

interface OnBoardingRepository {
    fun isCompleted(): Boolean
    fun complete()
}