package com.dalisyron.supoffice.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dalisyron.data.entity.MovieInfoEntity
import com.dalisyron.data.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val moviesRepository: MovieRepository) : ViewModel() {
    private val movies_ = MutableLiveData<List<MovieInfoEntity>>()
    var movies: LiveData<List<MovieInfoEntity>> = movies_

    private val navigateToDetailFragment_ = MutableLiveData<Unit>()
    var navigateToDetailFragment: LiveData<Unit> = navigateToDetailFragment_

    fun onViewCreated() {
        moviesRepository.getDiscoverMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movieItems ->
                movies_.postValue(movieItems)
            }, { it ->
                println(it)
            })
    }
}