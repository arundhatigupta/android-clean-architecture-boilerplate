package com.arundhati.androidcleanarchitectureboilerplate.app.base

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.arundhati.androidcleanarchitectureboilerplate.app.extensions.inflate

abstract class BaseLoadingAdapter<T>: RecyclerView.Adapter<BaseViewHolder<T>>(){

    protected val itemsList = ArrayList<T>()

    val isEmpty:Boolean
        get() = itemsList.isEmpty()

    open fun setList(data: List<T>){
        itemsList.clear()
        itemsList.addAll(data)
        notifyDataSetChanged()
    }

    @LayoutRes
    abstract fun getLoadingId(): Int

    open fun getLoadingItemCount(): Int{
        return 4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val view = parent.inflate(viewType)
        return when(viewType){
            getLoadingId() -> {
                LoadingViewHolder(view)
            }
            else -> {
                TODO("ViewHolder is missing")
            }
        } as BaseViewHolder<T>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int, payloads: MutableList<Any>) {
        if (!isEmpty) {
            holder.setData(itemsList[position])
        }
    }

    override fun getItemCount(): Int {
        return if(isEmpty) getLoadingItemCount() else itemsList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        if (!isEmpty) {
            holder.setData(itemsList[position])
        }
    }

    abstract fun getNonLoadingViewType(position: Int): Int

    override fun getItemViewType(position: Int): Int {
        return if (isEmpty) getLoadingId() else getNonLoadingViewType(position)
    }

}