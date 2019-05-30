package com.dalisyron.data.datasource

import com.dalisyron.data.entity.MovieInfoEntity
import io.reactivex.Single

interface MovieRemoteDataSource {
    fun getDiscoverMovies(): Single<List<MovieInfoEntity>>

    fun getGenreNameById(id : Int) : Single<String>
}