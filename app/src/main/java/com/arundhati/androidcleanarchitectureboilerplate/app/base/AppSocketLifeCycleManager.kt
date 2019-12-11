package com.arundhati.androidcleanarchitectureboilerplate.app.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppSocketLifeCycleManager @Inject constructor() : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {

    }

    private fun connectSocket(invalidate: Boolean = false) {

    }

    private fun disconnectSocket() {

    }
}