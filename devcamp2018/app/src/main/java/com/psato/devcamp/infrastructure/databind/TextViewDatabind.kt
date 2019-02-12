package com.psato.devcamp.infrastructure.databind

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

fun <T:CharSequence> TextView.text(text: LiveData<T>, owner: LifecycleOwner = context as AppCompatActivity, transformer : (value:T) -> T = {it}) {
    text.observe(owner, Observer {
        it?.let {
            this.text = transformer(it)
        }
    })
}


