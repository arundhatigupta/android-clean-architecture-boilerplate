package com.arundhati.androidcleanarchitectureboilerplate.app.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatDialogFragment
import javax.inject.Inject

abstract class DaggerBaseDialogFragment<VM : BaseViewModel> : DaggerAppCompatDialogFragment(){

    protected lateinit var viewModel: VM
    var isFragmentShowCalled = false
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    fun setDataToArguments(bundle: Bundle?){
        arguments = bundle
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeClickEvents()
        observeViewModelEvents()
        setUpView()
    }

    open fun setUpView(){

    }


    /**
     * Observes Rxview events
     */
    open fun observeClickEvents(){

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

    /**
     * implement this and provide viewmodel
     */
    abstract fun getViewModelInstance(): VM

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = getViewModelInstance()
    }

    abstract fun getHeight(): Int

    abstract fun getWidth(): Int

    abstract fun getBackgroundDrawableRes(): Int

    override fun onStart() {
        super.onStart()
        val d = dialog
        if (d != null) {
            d.window.setLayout(getWidth(), getHeight())
            d.window.setBackgroundDrawableResource(getBackgroundDrawableRes())
        }
    }

    override fun dismiss() {
        super.dismiss()
        isFragmentShowCalled = false
    }
}