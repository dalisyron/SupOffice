package com.dalisyron.supoffice.ui.home

import com.dalisyron.data.entity.MovieInfoEntity

interface OnHomeMovieItemClickListener {
    fun onItemClicked(movieInfoEntity: MovieInfoEntity)
}