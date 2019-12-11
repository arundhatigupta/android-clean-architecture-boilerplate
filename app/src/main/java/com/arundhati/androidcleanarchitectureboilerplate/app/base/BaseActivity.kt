package com.arundhati.androidcleanarchitectureboilerplate.app.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


/**
 * this is application base activity, extend this class for creating any activity
 */
abstract class BaseActivity<VM : BaseViewModel>: DaggerAppCompatActivity(){

    protected lateinit var viewModel: VM

    /**
     * todo need to think as it is possible to set it from resource value
     * todo if theme is not change dynamically
     */

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
     * implement this and provide viewmodel
     */
    abstract fun getViewModelInstance(): VM

    /**
     * Use this method for observing Rxview events
     */
    open fun observeClickEvents(){

    }

    /**
     * Use this method instead of onCreate. This is called after viewmodel creating and observable setting
     */
    open fun setUpView(){

    }

    /**
     * Use this method for observing livedata from viewmodel
     */
    open fun observeViewModelEvents(){

    }

    /**
     * return layout id to set inside {@link #setContentView(id)}
     */
    abstract fun getLayoutResId(): Int

}