package com.ae.rickandmortyapp.ui.characterlist.usecase

import com.ae.rickandmortyapp.dto.CharacterResponse

interface CharacterListUseCase {
    suspend fun invoke(): CharacterResponse
}