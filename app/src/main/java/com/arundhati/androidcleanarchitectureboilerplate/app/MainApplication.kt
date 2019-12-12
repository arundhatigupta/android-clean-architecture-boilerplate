package com.arundhati.androidcleanarchitectureboilerplate.app

import com.arundhati.androidcleanarchitectureboilerplate.BuildConfig
import com.arundhati.androidcleanarchitectureboilerplate.app.base.BaseApplication
import com.arundhati.androidcleanarchitectureboilerplate.app.di.AppComponent
import com.arundhati.androidcleanarchitectureboilerplate.app.di.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

/**
 * This is the main base for the Android application.
 */
class MainApplication : BaseApplication() {

    lateinit private var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        return appComponent
    }
}
