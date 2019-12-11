package com.arundhati.domain.base.usecases

import io.reactivex.Completable

interface CompletableUseCase {
    fun execute(): Completable
}