package com.psato.devcamp.presentation.search

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.psato.devcamp.data.entity.ShowResponse
import com.psato.devcamp.infrastructure.SingleLiveEvent
import com.psato.devcamp.infrastructure.databind.AdapterViewModel
import com.psato.devcamp.interactor.usecase.show.SearchShows
import java.util.*

class QueryViewModelArc
constructor(private val searchShows: SearchShows) : ViewModel(), AdapterViewModel<ShowResponseItem> {
    val queryValue = MutableLiveData<String>()

    val showLoading = MutableLiveData<Boolean>()

    val searchEnabled = MutableLiveData<Boolean>()

    private val showList = arrayListOf<ShowResponseItem>()

    private val queryObserver: Observer<String>

    private val notifyShowListUpdate = SingleLiveEvent<Any>()

    init {
        showLoading.value = false
        searchEnabled.value = false
        queryValue.value = ""
        queryObserver = Observer { query -> searchEnabled.value = !TextUtils.isEmpty(query) }
        queryValue.observeForever(queryObserver)
    }

    override fun onCleared() {
        super.onCleared()
        searchShows.unsubscribe()
        queryValue.removeObserver(queryObserver)
        for (showItem in showList) {
            showItem.onCleared()
        }
    }

    override fun getItemsCount(): Int {
        return showList.size
    }

    override fun getItemAtPosition(pos: Int): ShowResponseItem {
        return showList[pos]
    }

    override fun registerItemsForUpdate(owner: LifecycleOwner, observer: Observer<Any>) {
        notifyShowListUpdate.observe(owner, observer)
    }

    fun onQueryClick(view: View) {
        searchShow()
    }

    private fun searchShow() {
        showLoading.value = true
        val start = Date()
        queryValue.value?.let {
            searchShows.query = it
            searchShows.execute {

                onComplete { list: List<ShowResponse> ->
                    val end = Date()
                    Log.e("SATO", "SATO - Time: " + (end.time - start.time) / 1000 + "s")
                    showLoading.value = false
                    createItemList(list)
                    notifyShowListUpdate.call()
                }

                onError { throwable ->
                    showLoading.value = false
                }
            }
        }
    }

    private fun createItemList(list: List<ShowResponse>) {
        showList.clear()
        for (response: ShowResponse in list) {
            val showItem = ShowResponseItem(response)
            showList.add(showItem)
        }
    }

}
