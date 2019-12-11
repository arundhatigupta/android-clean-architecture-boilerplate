package com.arundhati.androidcleanarchitectureboilerplate.app.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppLifecycleHandler @Inject constructor(appSocketLifeCycleManager: AppSocketLifeCycleManager): Application.ActivityLifecycleCallbacks, LifecycleOwner {

    private var activityReferences = 0
    private var isActivityChangingConfigurations = false
    private var lifecycleRegistry = LifecycleRegistry(this)

    init {
        lifecycle.addObserver(appSocketLifeCycleManager)
    }
    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    override fun onActivityPaused(activity: Activity?) {
    }

    override fun onActivityResumed(activity: Activity?) {
    }

    override fun onActivityStarted(activity: Activity?) {

        if (++activityReferences == 1 && !isActivityChangingConfigurations) {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
        }
    }

    override fun onActivityDestroyed(activity: Activity?) {
        if (activityReferences == 0){
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity?) {
        isActivityChangingConfigurations = activity?.isChangingConfigurations!!
        if (--activityReferences == 0 && !isActivityChangingConfigurations) {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
        }
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        if (activityReferences == 0){
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        }
    }
}