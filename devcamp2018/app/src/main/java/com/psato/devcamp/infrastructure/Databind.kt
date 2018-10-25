package com.psato.devcamp.infrastructure

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView

fun View.visibility(visibility: LiveData<Boolean>, owner: LifecycleOwner = context as AppCompatActivity) {
    visibility.observe(owner, Observer {
        it?.let {
            if (it) {
                this.visibility = View.VISIBLE
            } else {
                this.visibility = View.GONE
            }
        }
    })
}

fun View.enabled(enabled: LiveData<Boolean>, owner: LifecycleOwner = context as AppCompatActivity) {
    enabled.observe(owner, Observer {
        it?.let {
            this.isEnabled = it
        }
    })
}

fun View.onClick(block: (View) -> Unit) {
    this.setOnClickListener {
        block.invoke(it)
    }
}

fun TextView.text(text: LiveData<String>, owner: LifecycleOwner = context as AppCompatActivity) {
    text.observe(owner, Observer {
        it?.let {
            this.text = it
        }
    })
}

fun EditText.text(text: MutableLiveData<String>, owner: LifecycleOwner = context as AppCompatActivity) {
    text.observe(owner, Observer {
        it?.let {
            if (it != (getText().toString()))
                this.setText(it)
        }
    })
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if (text.value != s.toString()) {
                text.value = s.toString()
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            //nothing to do
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //nothing to do
        }
    })
}