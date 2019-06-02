package com.dalisyron.remote.api

import com.dalisyron.remote.dto.DiscoverMoviesResponseDto
import com.dalisyron.remote.dto.MovieGenresListResponse
import io.reactivex.Single

class MovieServiceImpl : MovieService {
    init {
        instance = MovieService.create()
    }

    override fun getDiscoverMoviesResponse(): Single<DiscoverMoviesResponseDto> {
        return instance.getDiscoverMoviesResponse()
    }

    override fun getMovieGenreListResponse(): Single<MovieGenresListResponse> {
        return instance.getMovieGenreListResponse()
    }

    companion object {
        lateinit var instance: MovieService
    }
}