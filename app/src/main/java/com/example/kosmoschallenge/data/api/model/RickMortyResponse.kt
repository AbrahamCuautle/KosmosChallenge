package com.example.kosmoschallenge.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RickMortyResponse(
    @SerialName("info")
    val info: InfoResponse,
    @SerialName("results")
    val results: List<ResultResponse>,
)
@Serializable
data class InfoResponse(
    @SerialName("count")
    val count: Long,
    @SerialName("pages")
    val pages: Long,
    @SerialName("next")
    val next: String?,
    @SerialName("prev")
    val prev: String?,
)
@Serializable
data class ResultResponse(
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String?,
    @SerialName("status")
    val status: String?,
    @SerialName("species")
    val species: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("gender")
    val gender: String?,
    @SerialName("origin")
    val origin: OriginResponse?,
    @SerialName("location")
    val location: LocationResponse?,
    @SerialName("image")
    val image: String?,
    @SerialName("episode")
    val episode: List<String>?,
    @SerialName("url")
    val url: String?,
    @SerialName("created")
    val created: String?,
)

@Serializable
data class OriginResponse(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?,
)
@Serializable
data class LocationResponse(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?,
)