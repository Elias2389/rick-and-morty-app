package com.ae.rickandmortyapp.ui.characterlist.usecase

import androidx.paging.PagingData
import com.ae.rickandmortyapp.dto.ResultsItem
import kotlinx.coroutines.flow.Flow

interface CharacterListByPageUseCase {
    suspend fun invoke(page: Int): Flow<PagingData<ResultsItem>>
}