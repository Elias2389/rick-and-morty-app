package com.ae.rickandmortyapp.core.di

import com.ae.rickandmortyapp.ui.characterlist.repository.CharacterListRepository
import com.ae.rickandmortyapp.ui.characterlist.usecase.CharacterLisByPageUseCaseImpl
import com.ae.rickandmortyapp.ui.characterlist.usecase.CharacterListByPageUseCase
import com.ae.rickandmortyapp.ui.characterlist.usecase.CharacterListUseCase
import com.ae.rickandmortyapp.ui.characterlist.usecase.CharacterListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideCharacterListUseCase(repository: CharacterListRepository): CharacterListUseCase =
        CharacterListUseCaseImpl(repository)

    @Provides
    fun provideCharacterListByPageUseCase(repository: CharacterListRepository): CharacterListByPageUseCase =
        CharacterLisByPageUseCaseImpl(repository)
}