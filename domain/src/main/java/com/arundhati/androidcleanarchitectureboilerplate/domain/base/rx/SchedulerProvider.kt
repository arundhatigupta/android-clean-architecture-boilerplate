package com.arundhati.androidcleanarchitectureboilerplate.domain.base.rx

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun ui(): Scheduler
    fun io(): Scheduler
    fun computation(): Scheduler
}