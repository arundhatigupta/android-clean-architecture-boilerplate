package com.arundhati.androidcleanarchitectureboilerplate.app.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.arundhati.androidcleanarchitectureboilerplate.app.extensions.toast
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

abstract class DaggerBaseFragment<VM : BaseViewModel> : DaggerFragment() {

    protected lateinit var viewModel: VM
    protected var compositeDisposable: CompositeDisposable? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d(this::class.java.simpleName + " ${this.hashCode()}")
        observeClickEvents()
        observeViewModelEvents()
        setUpView()
    }

    /**
     * Use this method instead of onCreate. This is called after viewmodel creation and setting observers.
     */
    open fun setUpView() {

    }

    fun setDataToArguments(bundle: Bundle) {
        arguments = bundle
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        compositeDisposable = CompositeDisposable()
        viewModel = getViewModelInstance()
    }

    /**
     * Return layout id to set inside {@link #setContentView(id)}
     */
    abstract fun getLayoutResId(): Int

    /**
     * Implement to return the viewmodel instance
     */
    abstract fun getViewModelInstance(): VM


    /**
     * Observes Rxview events
     */
    open fun observeClickEvents() {

    }

    /**
     * Observes live data from viewmodel
     */
    open fun observeViewModelEvents() {

    }

    open fun onErrorMsg(msg: String): Boolean {
        context?.toast(msg)
        return true
    }

    override fun onDetach() {
        super.onDetach()
        compositeDisposable?.apply {
            if (!isDisposed) {
                dispose()
            }
        }
    }
}