package com.example.kosmoschallenge.mapper

import com.example.kosmoschallenge.data.api.model.ResultResponse
import com.example.kosmoschallenge.model.RickMortyCharacter

interface RickMortyMapper {
    fun map(result: ResultResponse): RickMortyCharacter

    fun mapAll(results: List<ResultResponse>): List<RickMortyCharacter>
}