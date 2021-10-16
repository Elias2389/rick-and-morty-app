package com.ae.rickandmortyapp.core.di

import com.ae.rickandmortyapp.data.datasource.characterlist.remote.CharacterListRemoteDataSource
import com.ae.rickandmortyapp.data.datasource.characterlist.remote.CharacterListRemoteDataSourceImpl
import com.ae.rickandmortyapp.data.service.CharacterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideCharacterListRemoteDataSource(characterService: CharacterService): CharacterListRemoteDataSource =
        CharacterListRemoteDataSourceImpl(characterService)
}