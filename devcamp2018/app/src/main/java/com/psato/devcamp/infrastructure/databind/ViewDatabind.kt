package com.psato.devcamp.infrastructure.databind

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.view.View

fun View.visibility(visibility: LiveData<Boolean>, owner: LifecycleOwner = context as AppCompatActivity, transformer : (value:Boolean) -> Boolean = {it}) {
    visibility.observe(owner, Observer {
        it?.let {
            if (transformer(it)) {
                this.visibility = View.VISIBLE
            } else {
                this.visibility = View.GONE
            }
        }
    })
}

fun View.enabled(enabled: LiveData<Boolean>, owner: LifecycleOwner = context as AppCompatActivity, transformer : (value:Boolean) -> Boolean = {it}) {
    enabled.observe(owner, Observer {
        it?.let {
            this.isEnabled = transformer(it)
        }
    })
}

fun View.onClick(block: (view: View) -> Unit) {
    this.setOnClickListener {
        block(it)
    }
}

fun View.focusable(focusable: LiveData<Boolean>, owner: LifecycleOwner = context as AppCompatActivity, transformer : (value:Boolean) -> Boolean = {it}) {
    focusable.observe(owner, Observer {
        it?.let { focusable ->
            this.isFocusable = transformer(focusable)
        }
    })
}

fun View.focusableInTouchMode(focusable: LiveData<Boolean>, owner: LifecycleOwner = context as AppCompatActivity, transformer : (value:Boolean) -> Boolean = {it}) {
    focusable.observe(owner, Observer {
        it?.let { focusable ->
            this.isFocusableInTouchMode = transformer(focusable)
        }
    })
}