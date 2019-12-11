package com.arundhati.androidcleanarchitectureboilerplate.app.di

import com.arundhati.androidcleanarchitectureboilerplate.app.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}