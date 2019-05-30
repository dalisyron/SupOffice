package com.dalisyron.supoffice.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dalisyron.data.entity.MovieInfoEntity

class HomeViewModel : ViewModel() {
    private val movies_ = MutableLiveData<MovieInfoEntity>()
    var movies : LiveData<MovieInfoEntity> = movies_

    private val navigateToDetailFragment_ = MutableLiveData<Unit>()
    var navigateToDetailFragment : LiveData<Unit> = navigateToDetailFragment_

}