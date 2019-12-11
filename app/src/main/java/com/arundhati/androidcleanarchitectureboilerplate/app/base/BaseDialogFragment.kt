package com.arundhati.androidcleanarchitectureboilerplate.app.base

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import io.reactivex.disposables.CompositeDisposable

abstract class BaseDialogFragment: DialogFragment(){
    private var compositeDisposable: CompositeDisposable?= null

    var isFragmentShowCalled = false

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        compositeDisposable = CompositeDisposable()
    }

    fun getCompositeDisposable() = compositeDisposable

    fun setDataToArguments(bundle: Bundle){
        arguments = bundle
    }

    abstract fun getLayoutResId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeClickEvents()
        setUpView()
    }

    open fun setUpView(){

    }

    open fun observeClickEvents(){

    }

    abstract fun getHeight(): Int

    abstract fun getWidth(): Int

    abstract fun getBackgroundDrawableRes(): Int

    override fun onStart() {
        super.onStart()
        dialog?.window?.let {
            it.setLayout(getWidth(), getHeight())
            it.setBackgroundDrawableResource(getBackgroundDrawableRes())
        }
    }

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        isFragmentShowCalled = false
    }

    override fun show(manager: FragmentManager?, tag: String?) {
        isFragmentShowCalled = true
        try {
            super.show(manager, tag)
        } catch (ex: IllegalStateException) {
            isFragmentShowCalled = false
        }
    }

    override fun show(transaction: FragmentTransaction?, tag: String?): Int {
        isFragmentShowCalled = true
        try {
            return super.show(transaction, tag)
        } catch (ex: IllegalStateException) {
            isFragmentShowCalled = false
        }
        return -1
    }
}