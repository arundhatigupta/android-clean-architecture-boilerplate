package com.arundhati.domain.base.usecases

import io.reactivex.Observable

interface ObservableUseCaseWithParams<P, R> {
    fun execute(params: P): Observable<R>
}