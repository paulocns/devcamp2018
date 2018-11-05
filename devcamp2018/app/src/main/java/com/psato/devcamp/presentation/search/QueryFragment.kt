package com.psato.devcamp.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.psato.devcamp.R
import com.psato.devcamp.infrastructure.bindView
import com.psato.devcamp.infrastructure.databind.*
import com.psato.devcamp.presentation.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class QueryFragment : BaseFragment() {
    val searchButton: Button by bindView(R.id.search_button)
    val loadinLayout: ViewGroup by bindView(R.id.loading_layout)
    val queryEditText: EditText by bindView(R.id.edit_query)
    val showResponse: TextView by bindView(R.id.show_response)
    val queryViewModelArc: QueryViewModelArc by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_query_mvvm, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchButton.enabled(queryViewModelArc.searchEnabled, this)
        loadinLayout.visibility(queryViewModelArc.showLoading, this)
        searchButton.onClick(queryViewModelArc::onQueryClick)
        queryEditText.text(queryViewModelArc.queryValue, this)
        showResponse.text(queryViewModelArc.result, this)
    }
}
