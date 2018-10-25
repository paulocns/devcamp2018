package com.psato.devcamp.presentation.search

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.psato.devcamp.R
import com.psato.devcamp.infrastructure.*
import com.psato.devcamp.presentation.base.BaseFragment

class QueryFragment : BaseFragment() {
    val searchButton: Button by bindView(R.id.search_button)
    val loadinLayout: ViewGroup by bindView(R.id.loading_layout)
    val queryEditText: EditText by bindView(R.id.edit_query)
    val showResponse: TextView by bindView(R.id.show_response)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_query_mvvm, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val queryViewModelArc: QueryViewModelArc = ViewModelProviders.of(this, viewModelFactory).get(QueryViewModelArc::class.java)
        searchButton.enabled(queryViewModelArc.searchEnabled)
        loadinLayout.visibility(queryViewModelArc.showLoading)
        searchButton.onClick {
            queryViewModelArc.onQueryClick(it)
        }
        queryEditText.text(queryViewModelArc.queryValue)
        showResponse.text(queryViewModelArc.result)
    }
}
