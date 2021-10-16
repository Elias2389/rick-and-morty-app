package com.ae.rickandmortyapp.ui.characterlist.usecase

import androidx.paging.PagingData
import com.ae.rickandmortyapp.dto.ResultsItem
import com.ae.rickandmortyapp.ui.characterlist.repository.CharacterListRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
class CharacterLisByPageUseCaseImpl @Inject constructor(
    private val repository: CharacterListRepository
): CharacterListByPageUseCase {

    override suspend fun invoke(page: Int): Flow<PagingData<ResultsItem>> {
        return repository.getAllCharacterListByPageRemote(page)
    }

}