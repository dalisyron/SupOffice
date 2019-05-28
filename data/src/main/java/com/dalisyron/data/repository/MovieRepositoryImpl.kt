package com.dalisyron.data.repository

import com.dalisyron.data.Mappers.toMovieInfo
import com.dalisyron.data.datasource.MovieRemoteDataSource
import com.dalisyron.domain.model.MovieInfo
import com.dalisyron.domain.repository.MovieRepository
import io.reactivex.Single

class MovieRepositoryImpl(private val movieRemoteDataSource: MovieRemoteDataSource) : MovieRepository {
    override fun getDiscoverMovies(): Single<List<MovieInfo>> {
        return movieRemoteDataSource.getDiscoverMovies().map { movieInfoEntityList ->
            movieInfoEntityList.map {
                it -> it.toMovieInfo()
            }
        }
    }
}
