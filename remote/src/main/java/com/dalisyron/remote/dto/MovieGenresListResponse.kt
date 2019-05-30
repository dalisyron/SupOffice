package com.dalisyron.remote.dto


import com.google.gson.annotations.SerializedName

data class MovieGenresListResponse(
    @SerializedName("genres")
    val genres: List<GenreDto>
)