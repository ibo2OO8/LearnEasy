package com.ibrohimapk3.learneasy.presentation.screen.game.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrohimapk3.learneasy.domain.entity.VocabularyModel
import com.ibrohimapk3.learneasy.domain.usecase.saveLevel.GetLevelUseCase
import com.ibrohimapk3.learneasy.domain.usecase.vocabulary.GetAllIVocabularyUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WordTranslationViewModel(
    private val getAllVocabularyUseCase: GetAllIVocabularyUseCase,
    private var getLevelUseCase: GetLevelUseCase

) : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState = _uiState.asStateFlow()

    private val _list =
        MutableStateFlow<List<VocabularyModel>>(emptyList())
    val list = _list.asStateFlow()

    private val _russianList =
        MutableStateFlow<List<String>>(emptyList())
    val russianList = _russianList.asStateFlow()

    private val _answer = MutableStateFlow("")
    val answer = _answer.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {

            var level: String? = "b1"
            try {
                level = getLevelUseCase.getLevel()
            } catch (e: Exception) {
            }
            Log.d("log123", level.toString())
            val vocabulary = getAllVocabularyUseCase.invoke(level.toString())

            _list.value = vocabulary

            _uiState.update {
                it.copy(isLoading = false)
            }

            if (vocabulary.isNotEmpty()) {
                getItem()
            }
        }
    }

    fun getItem() {
        val vocabulary = _list.value

        if (vocabulary.size < 4) return

        val questions = vocabulary.shuffled().take(4)

        _russianList.value = questions.map { it.russian }
        _answer.value = questions.first().english
    }

    fun selectOption(option: String) {
        if (_uiState.value.isFinished) return

        _uiState.update {
            it.copy(selectedOption = option)
        }
    }

    fun checkAnswer() {
        val state = _uiState.value
        val selected = state.selectedOption

        if (selected.isBlank() || state.isFinished) return

        val correct = selected == _russianList.value.firstOrNull()

        val newCorrectAnswers =
            if (correct) state.correctAnswers + 1
            else state.correctAnswers

        val nextQuestion = state.currentQuestion + 1

        _uiState.update {
            it.copy(
                currentQuestion = nextQuestion,
                correctAnswers = newCorrectAnswers,
                selectedOption = "",
                isFinished = nextQuestion >= state.totalQuestions
            )
        }

        if (nextQuestion < state.totalQuestions) {
            getItem()
        }
    }

    fun restartGame() {
        _uiState.value = GameUiState(
            totalQuestions = 10,
            isLoading = false
        )

        getItem()
    }
}

data class GameUiState(
    val currentQuestion: Int = 0,
    val correctAnswers: Int = 0,
    val totalQuestions: Int = 10,
    val selectedOption: String = "",
    val isFinished: Boolean = false,
    val isLoading: Boolean = true
) {
    val progress: Float
        get() = currentQuestion.toFloat() / totalQuestions

    val percentage: Int
        get() = if (totalQuestions > 0) {
            correctAnswers * 100 / totalQuestions
        } else 0
}
