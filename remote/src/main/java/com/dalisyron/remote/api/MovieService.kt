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

        fun create(): MovieService {
            val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            okHttpClientBuilder.addInterceptor(
                object : Interceptor {
                    override fun intercept(chain: Interceptor.Chain): Response {
                        var request = chain.request()
                        val url =
                            request.url().newBuilder().addQueryParameter("api_key", "140a29128656a78bf9d8a496df29cb7f")
                                .build()
                        request = request.newBuilder().url(url).build()
                        return chain.proceed(request)
                    }
                }
            )
            return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClientBuilder.build())
                .build().create()
        }
    }
}