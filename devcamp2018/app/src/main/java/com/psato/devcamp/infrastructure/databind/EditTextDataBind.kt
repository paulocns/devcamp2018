package com.psato.devcamp.infrastructure.databind

import android.arch.lifecycle.*
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.lang.ref.WeakReference

fun EditText.text(text: MutableLiveData<String>, owner: LifecycleOwner = context as AppCompatActivity) {
    text.observe(owner, Observer {
        it?.let { value ->
            if (value != (getText().toString()))
                this.setText(value)
        }
    })
    this.addTextChangedListener(TextTwoWayBind(text,this))


}

class TextTwoWayBind : LifecycleObserver, TextWatcher {

    private val editTextReference: WeakReference<EditText>

    private val textReference: WeakReference<MutableLiveData<String>>

    constructor(text: MutableLiveData<String>, editText: EditText) {
        editTextReference = WeakReference(editText)
        textReference = WeakReference(text)
    }

    override fun afterTextChanged(s: Editable?) {
        val text = textReference.get()
        text?.let {
            if (it.value != s.toString()) {
                it.value = s.toString()
            }
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //nothing to do
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //nothing to do
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun removeListenerListener() {
        val editText = editTextReference.get()
        editText?.let {
            it.removeTextChangedListener(this)
        }
    }

}