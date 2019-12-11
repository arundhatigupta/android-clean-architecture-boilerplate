package com.arundhati.domain.base.usecases

import io.reactivex.Observable

interface ObservableUseCase<R> {
    fun execute(): Observable<R>?
}