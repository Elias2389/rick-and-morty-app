package com.ae.rickandmortyapp.data.service

import com.ae.rickandmortyapp.dto.CharacterResponse
import com.ae.rickandmortyapp.dto.Info
import com.ae.rickandmortyapp.dto.ResultsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET("character")
    suspend fun getAllCharacters(): CharacterResponse

    @GET("character")
    suspend fun getCharactersByPage(
        @Query("page") page: Int
    ): Response<CharacterResponse>
}