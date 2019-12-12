package com.arundhati.androidcleanarchitectureboilerplate.app.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


/**
 * This is the base activity that can be extended to create any activity
 */
abstract class BaseActivity<VM : BaseViewModel>: DaggerAppCompatActivity(){

    protected lateinit var viewModel: VM

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        viewModel = getViewModelInstance()
        observeClickEvents()
        observeViewModelEvents()
        setUpView()
    }

    /**
     * Returns viewmodel instance when implemented
     */
    abstract fun getViewModelInstance(): VM

    /**
     * Observes Rxview events when implemented
     */
    open fun observeClickEvents(){

    }

    /**
     * Used instead of onCreate
     */
    open fun setUpView(){

    }

    /**
     * Observes livedata from viewmodel
     */
    open fun observeViewModelEvents(){

    }

    /**
     * Returns layout id to set inside {@link #setContentView(id)}
     */
    abstract fun getLayoutResId(): Int

}