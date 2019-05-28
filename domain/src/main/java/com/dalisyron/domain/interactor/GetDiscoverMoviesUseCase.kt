package com.dalisyron.domain.interactor

import com.dalisyron.domain.executor.PostExecutorThread
import com.dalisyron.domain.executor.UseCaseExecutorThread
import com.dalisyron.domain.interactor.base.SingleUseCase
import com.dalisyron.domain.model.MovieInfo
import com.dalisyron.domain.repository.MovieRepository
import io.reactivex.Single

class GetDiscoverMoviesUseCase(
    private val useCaseExecutorThread: UseCaseExecutorThread,
    private val postExecutorThread: PostExecutorThread,
    private val repository: MovieRepository
) : SingleUseCase<Nothing, List<MovieInfo>>(useCaseExecutorThread, postExecutorThread){
    override fun buildSingle(params: Nothing): Single<List<MovieInfo>> {
        return repository.getDiscoverMovies()
    }
}