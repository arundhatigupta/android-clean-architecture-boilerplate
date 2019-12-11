package com.arundhati.domain.base.usecases

import io.reactivex.Completable

interface CompletableUseCaseWithParams<P> {
    fun execute(params: P): Completable
}