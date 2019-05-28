package com.dalisyron.domain.repository

import com.dalisyron.domain.model.MovieInfo
import io.reactivex.Single

interface MovieRepository {
    fun getDiscoverMovies(): Single<List<MovieInfo>>
}