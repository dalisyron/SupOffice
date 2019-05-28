package com.dalisyron.supoffice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dalisyron.data.repository.MovieRepositoryImpl
import com.dalisyron.domain.executor.PostExecutorThread
import com.dalisyron.domain.executor.UseCaseExecutorThread
import com.dalisyron.domain.interactor.GetDiscoverMoviesUseCase
import com.dalisyron.remote.api.MovieService
import com.dalisyron.remote.datasource.MovieRemoteDataSourceImpl
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        val useCaseExecutorThread = object : UseCaseExecutorThread {
            override val scheduler: Scheduler
                get() = Schedulers.io()
        }

        val postExecutorThread = object : PostExecutorThread {
            override val scheduler: Scheduler
                get() = AndroidSchedulers.mainThread()
        }

        val movieRepository = MovieRepositoryImpl(MovieRemoteDataSourceImpl(MovieService.create()))

        val getDiscoverMoviesUseCase = GetDiscoverMoviesUseCase<Unit>(
            useCaseExecutorThread,
            postExecutorThread,
            movieRepository
        )

        getDiscoverMoviesUseCase.execute(
            Unit,
            { it -> println("Usecase response " + it.toString()) },
            { it -> print(it) })
        */
    }
}