package com.example.kosmoschallenge.data.repository

import com.example.kosmoschallenge.data.api.model.ResultResponse

interface RickMortyRepository {
    suspend fun getAllCharacters(): List<ResultResponse>
}