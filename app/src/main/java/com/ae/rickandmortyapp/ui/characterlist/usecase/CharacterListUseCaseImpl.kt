package com.ae.rickandmortyapp.ui.characterlist.usecase

import com.ae.rickandmortyapp.dto.CharacterResponse
import com.ae.rickandmortyapp.ui.characterlist.repository.CharacterListRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterListUseCaseImpl @Inject constructor(
    private val repository: CharacterListRepository
): CharacterListUseCase {

    override suspend fun invoke(): CharacterResponse {
        return repository.getAllCharacterListRemote()
    }
}