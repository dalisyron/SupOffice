package com.dalisyron.remote.api

import org.junit.Test

class MovieServiceImplTest {

    val instance = MovieServiceImpl()

    @Test
    fun getDiscoverMoviesResponse() {
        instance.getDiscoverMoviesResponse().doOnSuccess { it ->
            println("Value is $it")
        }.test()
            .assertComplete()
    }

    @Test
    fun getMovieGenreListResponse() {
        instance.getMovieGenreListResponse().doOnSuccess { it ->
            println("Value is $it")
        }.test()
            .assertComplete()
    }
}

fun main() {
    val test = MovieServiceImplTest()
    test.getDiscoverMoviesResponse()
}