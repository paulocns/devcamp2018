package com.psato.devcamp.presentation.home

import android.arch.lifecycle.ViewModel
import android.view.View
import com.psato.devcamp.infrastructure.SingleLiveEvent

class HomeFragmentViewModel : ViewModel() {

    val startSearch = SingleLiveEvent<Any>()

    fun onMVVMClicked(view: View) {
        startSearch.call()
    }
}
