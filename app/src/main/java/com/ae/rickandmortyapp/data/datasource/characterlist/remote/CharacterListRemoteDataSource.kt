package com.ae.rickandmortyapp.data.datasource.characterlist.remote

import com.ae.rickandmortyapp.data.service.CharacterService
import com.ae.rickandmortyapp.dto.CharacterResponse
import retrofit2.Response

interface CharacterListRemoteDataSource {

    suspend fun getAllCharacterListRemote(): CharacterResponse

    suspend fun getAllCharacterListByPageRemote(page: Int): Response<CharacterResponse>
}