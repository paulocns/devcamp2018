package com.psato.devcamp.presentation.home

import android.arch.lifecycle.ViewModel
import android.view.View
import com.psato.devcamp.infrastructure.SingleLiveEvent
import javax.inject.Inject

class HomeFragmentViewModel @Inject
constructor() : ViewModel() {

    val startSearch = SingleLiveEvent<Any>()

    fun onMVVMClicked(view: View) {
        startSearch.call()
    }
}
