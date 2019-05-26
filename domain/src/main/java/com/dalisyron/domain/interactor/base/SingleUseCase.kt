package com.dalisyron.domain.interactor.base

import com.dalisyron.domain.executor.PostExecutorThread
import com.dalisyron.domain.executor.UseCaseExecutorThread
import io.reactivex.Observer
import io.reactivex.Single

abstract class SingleUseCase <in Params, Result>(
    private val useCaseExecutorThread: UseCaseExecutorThread,
    private val postExecutorThread: PostExecutorThread
) : UseCase() {
    abstract fun buildSingle(params : Params) : Single<Result>

    fun execute(
        params : Params,
        success : (Result) -> Unit,
        failure : (Throwable) -> Unit
    ) {
        buildSingle(params)
            .observeOn(postExecutorThread.scheduler)
            .subscribeOn(useCaseExecutorThread.scheduler)
            .subscribe({
                success(it)
            }, {
                failure(it)
            }).also {
                add(it)
            }
    }
}