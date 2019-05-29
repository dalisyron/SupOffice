package com.dalisyron.remote.datasource

import com.dalisyron.data.datasource.MovieRemoteDataSource
import com.dalisyron.data.entity.MovieInfoEntity
import com.dalisyron.remote.mappers.toMovieEntity
import com.dalisyron.remote.api.MovieService
import com.dalisyron.remote.dto.DiscoverMoviesResponseDto
import io.reactivex.Single

class MovieRemoteDataSourceImpl(private val movieService: MovieService) : MovieRemoteDataSource {
    override fun getDiscoverMovies(): Single<List<MovieInfoEntity>> {
        return movieService.getDiscoverMovies().map { discoverMoviesDto: DiscoverMoviesResponseDto ->
            discoverMoviesDto.items.map {
                it.toMovieEntity()
            }
        }
    }
}