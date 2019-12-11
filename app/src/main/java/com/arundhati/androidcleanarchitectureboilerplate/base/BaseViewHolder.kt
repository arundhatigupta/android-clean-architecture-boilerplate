package com.arundhati.androidcleanarchitectureboilerplate.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * this is base ViewHolder, extend this only for creating viewholder and maintain the base behaviour
 */
abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view){

    var adapterCallback: BaseAdapterItemClick<T>?=null
    protected var dataModel: T?=null
    open fun setData(data: T){
        dataModel = data
    }
    /**
     * use this method only to pass itemclicklistener reference. You can create different itemclicklistener by extending
     * with {@link #BaseAdapterItemClick<> class}
     */
    fun setCallbackListener(callback: BaseAdapterItemClick<T>?) {
        adapterCallback = callback
    }

    open fun viewRecycled(){

    }
}