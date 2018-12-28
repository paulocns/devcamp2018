package com.psato.devcamp.presentation.search

import android.arch.lifecycle.MutableLiveData
import com.psato.devcamp.data.entity.ShowResponse
import com.psato.devcamp.infrastructure.databind.ChildViewModel

class ShowResponseItem(val showResponse: ShowResponse) : ChildViewModel() {
    val showName = MutableLiveData<String>()

    init {
        showName.value = showResponse.name
    }
}