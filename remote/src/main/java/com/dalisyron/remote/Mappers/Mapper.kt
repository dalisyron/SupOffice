package com.dalisyron.remote.Mappers

import com.dalisyron.data.entity.MovieInfoEntity
import com.dalisyron.remote.dto.MovieInfoDto

fun MovieInfoDto.toMovieEntity(): MovieInfoEntity {
    return MovieInfoEntity(
        genreIds = genreIds,
        id = id,
        originalLanguage = originalLanguage,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}