package com.arundhati.androidcleanarchitectureboilerplate.domain.base.usecases

interface UseCase<R> {
    fun execute(): R
}