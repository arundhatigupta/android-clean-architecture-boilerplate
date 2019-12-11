package com.arundhati.domain.base.usecases

interface UseCase<R> {
    fun execute(): R
}