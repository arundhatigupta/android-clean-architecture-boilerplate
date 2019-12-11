package com.arundhati.domain.base.usecases

import io.reactivex.Flowable

interface FlowableUseCaseWithParams<P, R> {
    fun execute(params: P): Flowable<R>
}