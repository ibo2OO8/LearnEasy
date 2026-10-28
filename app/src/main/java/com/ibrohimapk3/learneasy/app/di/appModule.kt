package com.ibrohimapk3.learneasy.app.di

import com.ibrohimapk3.learneasy.data.repositopry.GrammarRepositoryImpl
import com.ibrohimapk3.learneasy.data.repositopry.LevelQuizRepositoryImpl
import com.ibrohimapk3.learneasy.data.repositopry.VocabularyRepositoryImpl
import com.ibrohimapk3.learneasy.domain.repository.GrammarRepository
import com.ibrohimapk3.learneasy.domain.repository.LevelQuizRepository
import com.ibrohimapk3.learneasy.domain.repository.VocabularyRepository
import com.ibrohimapk3.learneasy.domain.usecase.grammar.GetItemByIdUseCase
import com.ibrohimapk3.learneasy.domain.usecase.quiz.LevelQuizUseCase
import com.ibrohimapk3.learneasy.domain.usecase.vocabulary.GetAllItemUseCase
import com.ibrohimapk3.learneasy.presentation.screen.grammar.viewModel.GrammarItemViewModel
import com.ibrohimapk3.learneasy.presentation.screen.grammar.viewModel.GrammarViewModel
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.view_model.LevelQuizViewModel
import com.ibrohimapk3.learneasy.presentation.screen.vocabulary.view_model.VocabularyViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<VocabularyRepository> { VocabularyRepositoryImpl(androidContext()) }
    factory { GetAllItemUseCase(get()) }
    viewModel { VocabularyViewModel(get()) }

    single<GrammarRepository> { GrammarRepositoryImpl(androidContext()) }
    factory { com.ibrohimapk3.learneasy.domain.usecase.grammar.GetAllItemUseCase(get()) }
    viewModel { GrammarViewModel(get()) }

    factory { GetItemByIdUseCase(get()) }
    viewModel { GrammarItemViewModel(get()) }

    single<LevelQuizRepository> { LevelQuizRepositoryImpl(androidContext()) }
    factory { LevelQuizUseCase(get()) }
    viewModel { LevelQuizViewModel(get()) }
}