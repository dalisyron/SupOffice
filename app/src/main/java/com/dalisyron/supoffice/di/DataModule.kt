package com.dalisyron.supoffice.di

import com.dalisyron.data.datasource.MovieRemoteDataSource
import com.dalisyron.remote.datasource.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {
    @Binds
    abstract fun bindMovieRemoteDataSource(movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource

}