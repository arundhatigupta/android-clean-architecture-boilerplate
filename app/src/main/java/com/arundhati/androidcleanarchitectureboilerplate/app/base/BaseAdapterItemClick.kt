package com.arundhati.androidcleanarchitectureboilerplate.app.base

interface BaseAdapterItemClick<T> {
    /**
     * Use {@param viewType} to differentiate view clicks, {@param childs} is clicked item reference
     */
    fun onItemClick(viewType: Int, data:T)

}