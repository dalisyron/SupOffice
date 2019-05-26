package com.dalisyron.remote.dto


import com.google.gson.annotations.SerializedName

data class DiscoverMoviesResponseDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val items: List<MovieInfoDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)