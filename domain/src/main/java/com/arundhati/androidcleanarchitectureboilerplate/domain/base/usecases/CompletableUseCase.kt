package com.arundhati.androidcleanarchitectureboilerplate.domain.base.usecases

import io.reactivex.Completable

interface CompletableUseCase {
    fun execute(): Completable
}