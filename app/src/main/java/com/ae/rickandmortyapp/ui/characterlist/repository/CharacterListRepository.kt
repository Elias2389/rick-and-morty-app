package com.ae.rickandmortyapp.ui.characterlist.repository

import androidx.paging.PagingData
import com.ae.rickandmortyapp.dto.CharacterResponse
import com.ae.rickandmortyapp.dto.ResultsItem
import kotlinx.coroutines.flow.Flow

interface CharacterListRepository {

    suspend fun getAllCharacterListRemote(): CharacterResponse

    suspend fun getAllCharacterListByPageRemote(page: Int): Flow<PagingData<ResultsItem>>

}