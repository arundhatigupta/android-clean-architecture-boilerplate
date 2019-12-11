package com.arundhati.androidcleanarchitectureboilerplate.app.extensions

import androidx.fragment.app.Fragment

fun Fragment.isViewLive(): Boolean{
    return this.isAdded && this.view != null
}