package com.arundhati.androidcleanarchitectureboilerplate.app.di

import android.app.Application
import android.content.Context
import com.arundhati.androidcleanarchitectureboilerplate.app.rx.SchedulersFacade
import com.arundhati.androidcleanarchitectureboilerplate.domain.base.rx.SchedulerProvider
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Binds
    abstract fun providerScheduler(schedulersFacade: SchedulersFacade): SchedulerProvider
}