package com.dalisyron.supoffice.ui.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dalisyron.data.entity.MovieInfoEntity
import com.dalisyron.supoffice.R
import com.squareup.picasso.Picasso

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleTextView: TextView = itemView.findViewById(R.id.title)
    private val genreTextViews = listOf<TextView>(
        itemView.findViewById(R.id.genre1),
        itemView.findViewById(R.id.genre2),
        itemView.findViewById(R.id.genre3)
    )
    private val posterImageView: ImageView = itemView.findViewById(R.id.poster)
    private val overviewTextView: TextView = itemView.findViewById(R.id.overview)

    fun bind(
        movieInfoEntity: MovieInfoEntity,
        onHomeMovieItemClickListener: OnHomeMovieItemClickListener
    ) {
        titleTextView.text = movieInfoEntity.title

        for (i in 0..MAX_NO_GENRES - 1) {
            if (i < movieInfoEntity.genres.size) {
                genreTextViews[i].text = movieInfoEntity.genres[i]
            } else {
                genreTextViews[i].visibility = View.GONE
            }
        }

        Picasso.get().load(movieInfoEntity.posterPath).into(posterImageView)

        overviewTextView.text = movieInfoEntity.overview

        itemView.setOnClickListener {
            onHomeMovieItemClickListener.onItemClicked(movieInfoEntity)
        }
    }

    companion object {
        val MAX_NO_GENRES = 3
    }
}