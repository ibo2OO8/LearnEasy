package com.ibrohimapk3.learneasy.domain.usecase.story

import com.ibrohimapk3.learneasy.domain.repository.StoryRepository

class GetStoryUseCase(private val storyRepository: StoryRepository) {
    operator fun invoke(id: Int): List<String> {
        return storyRepository.getStory(id)
    }
}