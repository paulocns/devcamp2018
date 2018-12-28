package com.psato.devcamp.infrastructure.databind

import android.arch.lifecycle.ViewModel

open class ChildViewModel:ViewModel(){
    public override fun onCleared() {
        super.onCleared()
    }
}