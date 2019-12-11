package com.arundhati.domain.base.usecases

import io.reactivex.Single

interface SingleUseCase<R> {
    fun execute(): Single<R>?
}