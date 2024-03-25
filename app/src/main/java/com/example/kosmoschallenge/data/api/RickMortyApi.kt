package com.example.kosmoschallenge.data.api

import com.example.kosmoschallenge.data.api.model.RickMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyApi {
    @GET("/api/character")
    suspend fun fetchAllCharacters(@Query("page") page: Int = 1): RickMortyResponse
}