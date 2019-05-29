package com.dalisyron.supoffice.ui.home


import android.os.Bundle
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dalisyron.data.entity.MovieInfoEntity
import com.dalisyron.data.repository.MovieRepository
import com.dalisyron.remote.api.MovieService
import com.dalisyron.remote.datasource.MovieRemoteDataSourceImpl
import com.dalisyron.supoffice.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeFragment : OnHomeMovieItemClickListener, Fragment(){
    private lateinit var recyclerView: RecyclerView

    val movieRepository : MovieRepository by lazy {
        MovieRepository(MovieRemoteDataSourceImpl(MovieService.create()))
    }
    val viewModelFactory : HomeViewModelFactory by lazy {
        HomeViewModelFactory()
    }

    val viewModel : HomeViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

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

        movieRepository.getDiscoverMovies().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { movieInfoList ->
                showMovies(movieInfoList)
            }
    }

    fun showMovies(items : List<MovieInfoEntity>) {
        recyclerView.adapter = HomeAdapter(items, this)
    }

    override fun onItemClicked(movieInfoEntity: MovieInfoEntity) {
        Toast.makeText(requireContext(), "Item clicked", Toast.LENGTH_LONG)
    }
}
