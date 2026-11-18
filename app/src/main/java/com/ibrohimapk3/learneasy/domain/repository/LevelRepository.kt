package com.ibrohimapk3.learneasy.domain.repository

interface LevelRepository {
    fun getLevel(): String?

    fun saveLevel(level: String)

}
