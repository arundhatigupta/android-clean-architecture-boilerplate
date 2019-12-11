package com.arundhati.androidcleanarchitectureboilerplate.domain.base.usecases

import io.reactivex.Maybe

interface MaybeUseCase<R> {
    fun execute(): Maybe<R>
}