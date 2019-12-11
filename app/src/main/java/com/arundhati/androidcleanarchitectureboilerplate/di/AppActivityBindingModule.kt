package com.arundhati.androidcleanarchitectureboilerplate.di

import com.arundhati.androidcleanarchitectureboilerplate.MainActivity
import com.arundhati.androidcleanarchitectureboilerplate.di.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}