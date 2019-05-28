package com.dalisyron.data.Mappers

import com.dalisyron.data.entity.MovieInfoEntity
import com.dalisyron.domain.model.MovieInfo

fun MovieInfoEntity.toMovieInfo(): MovieInfo {
    return MovieInfo(
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