package com.ibrohimapk3.learneasy.app.di

import com.ibrohimapk3.learneasy.data.repositopry.VocabularyRepositoryImpl
import com.ibrohimapk3.learneasy.domain.repository.VocabularyRepository
import com.ibrohimapk3.learneasy.domain.usecase.vocabulary.GetAllItemByLevelUseCase
import com.ibrohimapk3.learneasy.presentation.screen.vocabulary.view_model.VocabularyViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<VocabularyRepository> { VocabularyRepositoryImpl(androidContext()) }
    factory { GetAllItemByLevelUseCase(get()) }
    viewModel { VocabularyViewModel(get()) }
}