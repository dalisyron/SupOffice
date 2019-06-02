package com.dalisyron.supoffice.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dalisyron.data.entity.MovieInfoEntity
import com.dalisyron.data.repository.MovieRepository
import com.dalisyron.supoffice.ui.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val moviesRepository: MovieRepository) : BaseViewModel() {
    private val movies_ = MutableLiveData<List<MovieInfoEntity>>()
    var movies: LiveData<List<MovieInfoEntity>> = movies_

    private val navigateToDetailFragment_ = MutableLiveData<MovieInfoEntity>()
    var navigateToDetailFragment: LiveData<MovieInfoEntity> = navigateToDetailFragment_

    fun onViewCreated() {
        moviesRepository.getDiscoverMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movieItems ->
                movies_.postValue(movieItems)
            }, { it ->
                println(it)
            }).addTo(disposables)
    }

    fun onMovieItemClicked(movieInfoEntity: MovieInfoEntity) {
        navigateToDetailFragment_.postValue(movieInfoEntity)
    }
}