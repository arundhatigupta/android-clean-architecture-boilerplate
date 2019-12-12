package com.arundhati.androidcleanarchitectureboilerplate.app.di

import android.app.Application
import com.arundhati.androidcleanarchitectureboilerplate.app.MainApplication
import com.arundhati.androidcleanarchitectureboilerplate.data.di.DataModule
import com.arundhati.androidcleanarchitectureboilerplate.device.di.DeviceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DeviceModule::class,
        DataModule::class,
        AppModule::class,
        ViewModelModule::class,
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        AppActivityBindingModule::class
    ]
)

interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}