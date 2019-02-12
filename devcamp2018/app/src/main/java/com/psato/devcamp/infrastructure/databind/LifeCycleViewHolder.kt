package com.psato.devcamp.infrastructure.databind

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View

abstract class LifeCycleViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView),LifecycleOwner {

    val lifecycle = LifecycleRegistry(this)

    override fun getLifecycle(): Lifecycle {
        return lifecycle
    }

    fun notifyBindViewHolder(){
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    fun notifyUnbindViewHolder(){
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

}