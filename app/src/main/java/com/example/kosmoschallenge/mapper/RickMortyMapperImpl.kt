package com.example.kosmoschallenge.mapper

import com.example.kosmoschallenge.data.api.model.ResultResponse
import com.example.kosmoschallenge.model.RickMortyCharacter

class RickMortyMapperImpl: RickMortyMapper {
    override fun map(result: ResultResponse): RickMortyCharacter {
        return RickMortyCharacter(
            id = result.id,
            name = result.name.orEmpty(),
            status = result.name.orEmpty(),
            species = result.status.orEmpty(),
            type = result.type.orEmpty(),
            gender = result.gender.orEmpty(),
            origin = RickMortyCharacter.Origin(
                name = result.origin?.name.orEmpty(),
                url = result.origin?.url.orEmpty()
            ),
            location = RickMortyCharacter.Location(
                name = result.location?.name.orEmpty(),
                url = result.location?.url.orEmpty()
            ),
            image = result.image.orEmpty(),
            episode = result.episode.orEmpty(),
            url = result.url.orEmpty(),
            created = result.created.orEmpty(),
        )
    }

    override fun mapAll(results: List<ResultResponse>): List<RickMortyCharacter> {
        return results.map(::map)
    }
}