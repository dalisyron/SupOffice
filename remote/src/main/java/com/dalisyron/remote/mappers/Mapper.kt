package com.dalisyron.remote.mappers

import com.dalisyron.data.entity.MovieInfoEntity
import com.dalisyron.remote.api.MovieService.Companion.IMAGE_BASE_URL
import com.dalisyron.remote.dto.MovieInfoDto

fun MovieInfoDto.toMovieEntity(genreById: HashMap<Int, String>): MovieInfoEntity {
    return MovieInfoEntity(
        genres = genreIds.map { it -> genreById[it] ?: "N/A" },
        id = id,
        originalLanguage = originalLanguage,
        overview = overview,
        popularity = popularity,
        posterPath = "$IMAGE_BASE_URL/$posterPath",
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}