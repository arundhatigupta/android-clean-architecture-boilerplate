package com.arundhati.androidcleanarchitectureboilerplate.domain.base.usecases

import io.reactivex.Maybe

interface MaybeUseCaseWithParams<P, R> {
    fun execute(params: P): Maybe<R>
}