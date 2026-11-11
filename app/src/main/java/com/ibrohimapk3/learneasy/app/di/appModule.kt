package com.ibrohimapk3.learneasy.app.di

import com.ibrohimapk3.learneasy.data.preferences.AppPreferences
import com.ibrohimapk3.learneasy.data.repository.GrammarRepositoryImpl
import com.ibrohimapk3.learneasy.data.repository.LevelQuizRepositoryImpl
import com.ibrohimapk3.learneasy.data.repository.OnBoardingRepositoryImpl
import com.ibrohimapk3.learneasy.data.repository.VocabularyRepositoryImpl
import com.ibrohimapk3.learneasy.domain.repository.GrammarRepository
import com.ibrohimapk3.learneasy.domain.repository.LevelQuizRepository
import com.ibrohimapk3.learneasy.domain.repository.OnBoardingRepository
import com.ibrohimapk3.learneasy.domain.repository.VocabularyRepository
import com.ibrohimapk3.learneasy.domain.usecase.grammar.GetAllItemUseCase
import com.ibrohimapk3.learneasy.domain.usecase.grammar.GetItemByIdUseCase
import com.ibrohimapk3.learneasy.domain.usecase.onboarding.CompleteUseCase
import com.ibrohimapk3.learneasy.domain.usecase.onboarding.IsCompletedUseCase
import com.ibrohimapk3.learneasy.domain.usecase.quiz.LevelQuizUseCase
import com.ibrohimapk3.learneasy.domain.usecase.vocabulary.GetAllIVocabularyUseCase
import com.ibrohimapk3.learneasy.presentation.activity.MainActivityViewModel
import com.ibrohimapk3.learneasy.presentation.screen.game.viewmodel.WordTranslationViewModel
import com.ibrohimapk3.learneasy.presentation.screen.grammar.viewmodel.GrammarItemViewModel
import com.ibrohimapk3.learneasy.presentation.screen.grammar.viewmodel.GrammarViewModel
import com.ibrohimapk3.learneasy.presentation.screen.main.viewmodel.HomeScreenViewModel
import com.ibrohimapk3.learneasy.presentation.screen.onboarding.viewmodel.LevelQuizViewModel
import com.ibrohimapk3.learneasy.presentation.screen.vocabulary.viewmodel.VocabularyViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { AppPreferences(androidContext()) }

    single<OnBoardingRepository> { OnBoardingRepositoryImpl(get()) }
    factory { CompleteUseCase(get()) }
    factory { IsCompletedUseCase(get()) }
    viewModel { MainActivityViewModel(get()) }

    viewModel { HomeScreenViewModel(get()) }

    single<VocabularyRepository> { VocabularyRepositoryImpl(androidContext()) }
    factory { GetAllIVocabularyUseCase(get()) }
    viewModel { VocabularyViewModel(get()) }

    single<GrammarRepository> { GrammarRepositoryImpl(androidContext()) }
    factory { GetAllItemUseCase(get()) }
    viewModel { GrammarViewModel(get()) }

    factory { GetItemByIdUseCase(get()) }
    viewModel { GrammarItemViewModel(get()) }

    single<LevelQuizRepository> { LevelQuizRepositoryImpl(androidContext()) }
    factory { LevelQuizUseCase(get()) }
    viewModel { LevelQuizViewModel(get()) }



    viewModel { WordTranslationViewModel(get()) }
}