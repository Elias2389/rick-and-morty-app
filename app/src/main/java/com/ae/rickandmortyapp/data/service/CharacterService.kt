package com.ae.rickandmortyapp.data.service

import com.ae.rickandmortyapp.dto.CharacterResponse
import retrofit2.http.GET

interface CharacterService {

    @GET("character")
    suspend fun getAllCharacters(): CharacterResponse
}