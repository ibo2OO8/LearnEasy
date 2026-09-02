package com.ibrohimapk3.learneasy.domain.repository

interface StoryRepository {
    fun getStory(id: Int): List<String>

    fun addStory(story: String)
}