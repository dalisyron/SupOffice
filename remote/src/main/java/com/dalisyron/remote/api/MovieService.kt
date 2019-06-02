package com.dalisyron.remote.api

import com.dalisyron.remote.dto.DiscoverMoviesResponseDto
import com.dalisyron.remote.dto.MovieGenresListResponse
import io.reactivex.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface MovieService {

    @GET("discover/movie")
    fun getDiscoverMoviesResponse(): Single<DiscoverMoviesResponseDto>

    @GET("genre/movie/list")
    fun getMovieGenreListResponse(): Single<MovieGenresListResponse>

    companion object {
        const val BASE_URL: String = "https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL: String = "https://image.tmdb.org/t/p/original"
    }
}