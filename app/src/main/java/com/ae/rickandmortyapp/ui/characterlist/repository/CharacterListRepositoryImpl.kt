package com.ae.rickandmortyapp.ui.characterlist.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ae.rickandmortyapp.data.datasource.characterlist.paging.CharactersPagingDataSource
import com.ae.rickandmortyapp.data.datasource.characterlist.remote.CharacterListRemoteDataSource
import com.ae.rickandmortyapp.data.service.CharacterService
import com.ae.rickandmortyapp.dto.CharacterResponse
import com.ae.rickandmortyapp.dto.ResultsItem
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow


@Singleton
class CharacterListRepositoryImpl @Inject constructor(
    private val remote: CharacterListRemoteDataSource,
    private val service: CharacterService
) : CharacterListRepository {
    override suspend fun getAllCharacterListRemote(): CharacterResponse {
        return remote.getAllCharacterListRemote()
    }

    override suspend fun getAllCharacterListByPageRemote(page: Int): Flow<PagingData<ResultsItem>> {
        return Pager(
            config = PagingConfig(pageSize = 10, prefetchDistance = 2),
            pagingSourceFactory = {CharactersPagingDataSource(service = service)}
        ).flow
    }
}