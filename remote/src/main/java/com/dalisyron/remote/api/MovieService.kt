package com.dalisyron.remote.api

interface MovieService {

    fun getDiscoverMovies()

    companion object {
        val BASE_URL : String = "https://api.themoviedb.org/3/"
    }
}