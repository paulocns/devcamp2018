package com.psato.devcamp.infrastructure.databind

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer

interface AdapterViewModel<T>{
    fun getItemsCount(): Int
    fun getItemAtPosition(pos: Int): T
    fun registerItemsForUpdate(owner:LifecycleOwner, observer: Observer<Any>)
    fun getViewType(position: Int): Int{
        return 0
    }

}