package com.psato.devcamp.infrastructure.databind

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

fun TextView.text(text: LiveData<String>, owner: LifecycleOwner = context as AppCompatActivity) {
    text.observe(owner, Observer {
        it?.let {
            this.text = it
        }
    })
}