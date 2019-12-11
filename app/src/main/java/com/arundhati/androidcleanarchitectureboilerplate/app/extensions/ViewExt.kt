package com.arundhati.androidcleanarchitectureboilerplate.app.extensions

import android.content.Context
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputLayout

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.remove(){
    this.visibility = View.GONE
}

fun View.hide(){
    this.visibility = View.INVISIBLE
}

fun View.isVisible() = this.visibility == View.VISIBLE

fun View.showOrRemove(show: Boolean){
    if (show) this.show() else this.remove()
}

fun ViewGroup.inflate(resId: Int): View = LayoutInflater.from(this.context)
    .inflate(resId, this, false)

fun <T>LiveData<T>.reObserve(lifeCycler: LifecycleOwner, observer: Observer<T>){
    this.removeObservers(lifeCycler)
    this.removeObserver(observer)
    this.observe(lifeCycler, observer)
}

fun EditText.setLengthLimit(length: Int) {
    val filterArray = arrayOfNulls<InputFilter>(1)
    filterArray[0] = InputFilter.LengthFilter(length)
    this.filters = filterArray
}

fun EditText.showKeyboard(){
    requestFocus()
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    inputMethodManager?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

fun EditText.hideKeyboard():Boolean{
    clearFocus()
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    return inputMethodManager?.hideSoftInputFromWindow(windowToken, 0)?:false
}

fun EditText.resetLengthLimit() {
    this.filters = arrayOf()
}

fun TextInputLayout.resetError(){
    this.error = null
}