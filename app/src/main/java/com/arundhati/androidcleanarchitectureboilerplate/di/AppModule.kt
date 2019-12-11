package com.arundhati.androidcleanarchitectureboilerplate.di

import android.app.Application
import android.content.Context
import com.arundhati.androidcleanarchitectureboilerplate.rx.SchedulersFacade
import com.arundhati.domain.base.rx.SchedulerProvider
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Binds
    abstract fun providerScheduler(schedulersFacade: SchedulersFacade): SchedulerProvider
}