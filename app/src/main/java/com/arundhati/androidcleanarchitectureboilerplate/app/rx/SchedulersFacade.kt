package com.arundhati.androidcleanarchitectureboilerplate.app.rx

import com.arundhati.androidcleanarchitectureboilerplate.domain.base.rx.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulersFacade @Inject constructor() : SchedulerProvider {

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}