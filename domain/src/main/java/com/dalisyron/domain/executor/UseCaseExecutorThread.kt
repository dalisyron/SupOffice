package com.dalisyron.domain.executor

import io.reactivex.Scheduler

interface UseCaseExecutorThread {
    val scheduler: Scheduler
}