package com.dalisyron.supoffice.di

import com.dalisyron.data.datasource.MovieRemoteDataSource
import com.dalisyron.remote.api.MovieService
import com.dalisyron.remote.datasource.MovieRemoteDataSourceImpl
import com.dalisyron.supoffice.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(
            object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    var request = chain.request()
                    val url =
                        request.url().newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY)
                            .build()
                    request = request.newBuilder().url(url).build()
                    return chain.proceed(request)
                }
            }
        )
        return okHttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun providesMovieService(okHttpClient: OkHttpClient): MovieService {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(MovieService.BASE_URL)
            .client(okHttpClient)
            .build().create()
    }

    @Singleton
    @Provides
    fun providesMovieRemoteDataSource(movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource {
        return movieRemoteDataSourceImpl
    }
}