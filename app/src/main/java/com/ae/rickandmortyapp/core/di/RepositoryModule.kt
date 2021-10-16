package com.ae.rickandmortyapp.core.di

import com.ae.rickandmortyapp.data.datasource.characterlist.remote.CharacterListRemoteDataSource
import com.ae.rickandmortyapp.data.datasource.characterlist.remote.CharacterListRemoteDataSourceImpl
import com.ae.rickandmortyapp.data.service.CharacterService
import com.ae.rickandmortyapp.ui.characterlist.repository.CharacterListRepository
import com.ae.rickandmortyapp.ui.characterlist.repository.CharacterListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideCharacterListRepository(
        remote: CharacterListRemoteDataSource,
        service: CharacterService
    ): CharacterListRepository =
        CharacterListRepositoryImpl(remote, service)
}