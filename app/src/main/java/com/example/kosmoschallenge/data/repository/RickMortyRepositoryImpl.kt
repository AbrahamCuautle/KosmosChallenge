package com.example.kosmoschallenge.data.repository

import com.example.kosmoschallenge.data.api.RickMortyApi
import com.example.kosmoschallenge.data.api.model.ResultResponse
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class RickMortyRepositoryImpl @Inject constructor(
    private val api: RickMortyApi
): RickMortyRepository {
    override suspend fun getAllCharacters(): List<ResultResponse> {
        return api.fetchAllCharacters().results
    }
}