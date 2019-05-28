package com.dalisyron.data.repository

import com.dalisyron.data.datasource.MovieRemoteDataSource
import com.dalisyron.data.entity.MovieInfoEntity
import io.reactivex.Single

class MovieRepository(private val movieRemoteDataSource: MovieRemoteDataSource) {
    fun getDiscoverMovies(): Single<List<MovieInfoEntity>> {
        return movieRemoteDataSource.getDiscoverMovies()
    }
}
