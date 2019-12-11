package com.arundhati.androidcleanarchitectureboilerplate.domain.base.usecases

import io.reactivex.Observable

interface ObservableUseCaseWithParams<P, R> {
    fun execute(params: P): Observable<R>
}