package com.ae.rickandmortyapp.ui.characterlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ae.rickandmortyapp.common.reponse.Resource
import com.ae.rickandmortyapp.common.reponse.ResponseHandler
import com.ae.rickandmortyapp.data.service.CharacterService
import com.ae.rickandmortyapp.dto.CharacterResponse
import com.ae.rickandmortyapp.ui.characterlist.usecase.CharacterListByPageUseCase
import com.ae.rickandmortyapp.ui.characterlist.usecase.CharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val userCase: CharacterListUseCase,
    private val userCaseByPage: CharacterListByPageUseCase
) : ViewModel() {

    fun getAllCharacters(): LiveData<Resource<CharacterResponse>> = liveData {
        try {
            val response = userCase.invoke()
            emit(ResponseHandler.handleSuccess(response))
        } catch (e: Exception) {
            emit(ResponseHandler.handleException<CharacterResponse>(e))
        }
    }

}