package com.arundhati.androidcleanarchitectureboilerplate.data.di

import dagger.Module

@Module(includes = [NetworkModule::class])
abstract class DataModule {
}