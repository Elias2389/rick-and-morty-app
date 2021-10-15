package com.ae.rickandmortyapp.ui.characterlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ae.rickandmortyapp.common.reponse.Resource
import com.ae.rickandmortyapp.common.reponse.ResponseHandler
import com.ae.rickandmortyapp.data.service.CharacterService
import com.ae.rickandmortyapp.dto.CharacterResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val characterService: CharacterService
) : ViewModel() {

    fun getAllCharacters(): LiveData<Resource<CharacterResponse>> = liveData {
        try {
            val response = characterService.getAllCharacters()
            emit(ResponseHandler.handleSuccess(response))
        } catch (e: Exception) {
            emit(ResponseHandler.handleException<CharacterResponse>(e))
        }
    }

}