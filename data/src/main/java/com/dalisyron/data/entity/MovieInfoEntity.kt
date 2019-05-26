package com.dalisyron.data.entity

data class MovieInfoEntity(
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int
)