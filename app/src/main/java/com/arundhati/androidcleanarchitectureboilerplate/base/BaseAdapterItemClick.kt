package com.arundhati.androidcleanarchitectureboilerplate.base

/**
 * this is base itemClickListener, extend this only for passing click reference into viewholder and maintain the base behaviour
 */
interface BaseAdapterItemClick<T> {
    /**
     * Use {@param viewType} to differentiate view clicks, {@param childs} is clicked item reference
     */
    fun onItemClick(viewType: Int, data:T)

}