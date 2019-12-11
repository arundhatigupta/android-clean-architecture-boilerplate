package com.arundhati.androidcleanarchitectureboilerplate.app.base

import android.content.Context
import androidx.multidex.MultiDex
import dagger.android.support.DaggerApplication

abstract class BaseApplication: DaggerApplication(){

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}