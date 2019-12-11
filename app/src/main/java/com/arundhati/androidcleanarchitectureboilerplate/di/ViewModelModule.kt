package com.arundhati.androidcleanarchitectureboilerplate.di

import androidx.lifecycle.ViewModelProvider
import com.arundhati.androidcleanarchitectureboilerplate.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}