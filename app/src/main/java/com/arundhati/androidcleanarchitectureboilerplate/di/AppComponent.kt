package com.arundhati.androidcleanarchitectureboilerplate.di

import android.app.Application
import com.arundhati.androidcleanarchitectureboilerplate.MainApplication
import com.arundhati.data.di.DataModule
import com.arundhati.device.di.DeviceModule
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