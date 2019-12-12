package com.arundhati.androidcleanarchitectureboilerplate.app.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : DaggerFragment() {

    protected var compositeDisposable: CompositeDisposable? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        compositeDisposable = CompositeDisposable()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeClickEvents()
        setUpView()
    }


    open fun setUpView() {

    }

    fun setDataToArguments(bundle: Bundle?) {
        arguments = bundle
    }

    /**
     * Return layout res id  to inflate view from {@link #onCreateView} method
     */
    abstract fun getLayoutResId(): Int


    /**
     * Use this method for observing Rxview events
     */
    open fun observeClickEvents() {

    }

    override fun onDetach() {
        super.onDetach()
        compositeDisposable?.dispose()
    }
}