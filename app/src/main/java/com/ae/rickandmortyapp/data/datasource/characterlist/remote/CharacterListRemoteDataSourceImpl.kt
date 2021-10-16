package com.ae.rickandmortyapp.data.datasource.characterlist.remote

import com.ae.rickandmortyapp.data.service.CharacterService
import com.ae.rickandmortyapp.dto.CharacterResponse
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.Response


@Singleton
class CharacterListRemoteDataSourceImpl @Inject constructor(
    private val characterService: CharacterService
) : CharacterListRemoteDataSource {

    override suspend fun getAllCharacterListRemote(): CharacterResponse {
        return characterService.getAllCharacters()
    }

    override suspend fun getAllCharacterListByPageRemote(
        page: Int
    ): Response<CharacterResponse> {
        return characterService.getCharactersByPage(page)
    }
}