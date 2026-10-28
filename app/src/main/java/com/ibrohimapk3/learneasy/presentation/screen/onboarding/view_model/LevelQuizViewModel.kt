package com.ibrohimapk3.learneasy.presentation.screen.onboarding.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrohimapk3.learneasy.domain.entity.LevelQuizModel
import com.ibrohimapk3.learneasy.domain.usecase.quiz.LevelQuizUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LevelQuizViewModel(
    private val getAllItemUseCase: LevelQuizUseCase
) : ViewModel() {

    private val _list = MutableStateFlow<List<LevelQuizModel>>(emptyList())
    val list = _list.asStateFlow()
    private val _level = MutableStateFlow("a1")
    val level = _level.asStateFlow()
    private val _levelIndex = MutableStateFlow(0)
    val levelIndex = _levelIndex.asStateFlow()
    private val _trueAnswer = MutableStateFlow(0)
    val trueAnswer = _trueAnswer.asStateFlow()
    private val _progress = MutableStateFlow(0f)
    val progress = _progress.asStateFlow()
    private val _showResult = MutableStateFlow(false)
    val showResult = _showResult.asStateFlow()

    private val _isPassed = MutableStateFlow(false)
    val isPassed = _isPassed.asStateFlow()

    private val requiredAnswers = 2

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val questions = withContext(Dispatchers.IO) {
                getAllItemUseCase.invoke(_level.value)
            }

            _list.value = questions
        }
    }

    fun checkAnswer(selected: String?) {
        if (_showResult.value) return

        val question = _list.value.getOrNull(_levelIndex.value)
            ?: return

        val correct = _trueAnswer.value +
                if (selected == question.answer) 1 else 0

        _trueAnswer.value = correct

        _progress.value =
            (_levelIndex.value + 1).toFloat() / _list.value.size

        if (_levelIndex.value == _list.value.lastIndex) {
            _isPassed.value = correct >= requiredAnswers
            _showResult.value = true
        } else {
            _levelIndex.value++
        }
    }

    fun continueToNextLevel() {
        if (!_isPassed.value) return

        val nextLevel = when (_level.value) {
            "a1" -> "a2"
            "a2" -> "b1"
            "b1" -> "b2"
            else -> return
        }

        _level.value = nextLevel
        resetQuiz()
        loadData()
    }

    private fun resetQuiz() {
        _levelIndex.value = 0
        _trueAnswer.value = 0
        _progress.value = 0f
        _showResult.value = false
        _isPassed.value = false
    }
}
