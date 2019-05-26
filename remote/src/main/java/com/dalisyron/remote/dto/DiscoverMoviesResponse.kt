package com.dalisyron.remote.dto

data class DiscoverMoviesResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)