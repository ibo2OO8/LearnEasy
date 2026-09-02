package com.ibrohimapk3.learneasy.domain.repository

interface ObBoardingRepository {
    fun isCompleted(): Boolean
    fun complete()
}