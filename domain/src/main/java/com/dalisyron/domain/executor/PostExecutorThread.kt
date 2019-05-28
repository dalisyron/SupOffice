package com.dalisyron.domain.executor

import io.reactivex.Scheduler

interface PostExecutorThread {
    val scheduler: Scheduler
}