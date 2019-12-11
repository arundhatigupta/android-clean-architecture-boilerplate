package com.arundhati.androidcleanarchitectureboilerplate.domain.base.usecases

import io.reactivex.Observable

interface ObservableUseCase<R> {
    fun execute(): Observable<R>?
}