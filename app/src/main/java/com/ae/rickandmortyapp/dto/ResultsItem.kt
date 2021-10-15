package com.ae.rickandmortyapp.dto

import com.google.gson.annotations.SerializedName

data class ResultsItem(
    @SerializedName("image")
    val image: String = "",
    @SerializedName("gender")
    val gender: String = "",
    @SerializedName("species")
    val species: String = "",
    @SerializedName("created")
    val created: String = "",
    @SerializedName("origin")
    val origin: Origin,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("location")
    val location: Location,
    @SerializedName("episode")
    val episode: List<String>?,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("type")
    val type: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("status")
    val status: String = ""
)