package com.example.kosmoschallenge.data.api.model

import com.google.gson.annotations.SerializedName

data class RickMortyResponse(
    @SerializedName("info")
    val info: InfoResponse,
    @SerializedName("results")
    val results: List<ResultResponse>,
)
data class InfoResponse(
    @SerializedName("count")
    val count: Long,
    @SerializedName("pages")
    val pages: Long,
    @SerializedName("next")
    val next: String?,
    @SerializedName("prev")
    val prev: String?,
)

data class ResultResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("species")
    val species: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("origin")
    val origin: OriginResponse?,
    @SerializedName("location")
    val location: LocationResponse?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("episode")
    val episode: List<String>?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("created")
    val created: String?,
)

data class OriginResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?,
)

data class LocationResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?,
)