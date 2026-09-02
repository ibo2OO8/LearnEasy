package com.ibrohimapk3.learneasy.domain.usecase.story

import com.ibrohimapk3.learneasy.domain.repository.StoryRepository

class AddStoryUseCase(private val storyRepository: StoryRepository) {
    operator fun invoke(story: String) {
        storyRepository.addStory(story)
    }
}