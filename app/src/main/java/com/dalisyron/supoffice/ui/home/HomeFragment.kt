package com.dalisyron.supoffice.ui.home


import android.graphics.Movie
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dalisyron.data.entity.MovieInfoEntity
import com.dalisyron.supoffice.MyApplication
import com.dalisyron.supoffice.R
import com.dalisyron.supoffice.ui.detail.DetailFragment
import javax.inject.Inject

class HomeFragment : OnHomeMovieItemClickListener, Fragment() {
    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        viewModel.movies.observe(this@HomeFragment, Observer(
            { movieItems: List<MovieInfoEntity> ->
                showMovies(movieItems)
            }
        ))

        viewModel.navigateToDetailFragment.observe(this@HomeFragment, Observer(
            { Unit ->
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.content_frame, DetailFragment())
                    ?.commit()
            }
        ))
        viewModel.onViewCreated()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApplication.component.inject(this)
    }

    fun showMovies(items: List<MovieInfoEntity>) {
        recyclerView.adapter = HomeAdapter(items, this)
    }

    override fun onItemClicked(movieInfoEntity: MovieInfoEntity) {
//        Toast.makeText(requireContext(), "Item clicked", Toast.LENGTH_LONG).show()
        viewModel.onMovieItemClicked(movieInfoEntity)
    }
}
