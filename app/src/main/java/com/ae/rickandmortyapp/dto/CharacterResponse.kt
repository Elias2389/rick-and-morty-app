package com.ae.rickandmortyapp.dto

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("results")
    val results: List<ResultsItem>?,
    @SerializedName("info")
    val info: Info
)