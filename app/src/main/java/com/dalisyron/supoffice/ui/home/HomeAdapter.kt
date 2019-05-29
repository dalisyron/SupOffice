package com.dalisyron.supoffice.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dalisyron.data.entity.MovieInfoEntity
import com.dalisyron.supoffice.R

class HomeAdapter(private val items : List<MovieInfoEntity>,
                  private val onHomeMovieItemClickListener: OnHomeMovieItemClickListener) : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(items[position], onHomeMovieItemClickListener)
    }

}