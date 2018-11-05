package com.psato.devcamp.infrastructure.databind

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

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