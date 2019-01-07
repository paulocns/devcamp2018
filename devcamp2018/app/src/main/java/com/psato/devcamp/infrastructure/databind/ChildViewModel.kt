package com.psato.devcamp.infrastructure.databind

import android.arch.lifecycle.ViewModel

abstract class ChildViewModel:ViewModel(){
    public override fun onCleared() {
        super.onCleared()
    }
}