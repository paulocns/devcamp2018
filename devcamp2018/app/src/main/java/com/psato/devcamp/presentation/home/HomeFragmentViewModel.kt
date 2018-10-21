package com.psato.devcamp.presentation.home

import android.arch.lifecycle.ViewModel
import android.content.Intent
import android.view.View
import com.psato.devcamp.infrastructure.LiveEvent

import javax.inject.Inject

class HomeFragmentViewModel @Inject
constructor() : ViewModel() {

    val startSearch = LiveEvent<Boolean>()

    fun onMVVMClicked(view: View) {
        startSearch.value =  true
    }
}
