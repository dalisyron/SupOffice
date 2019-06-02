package com.dalisyron.remote.api

import org.junit.Before
import org.junit.Test

class MovieServiceImplTest {

    lateinit var instance: MovieService

    @Before
    fun init() {
        instance
    }

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