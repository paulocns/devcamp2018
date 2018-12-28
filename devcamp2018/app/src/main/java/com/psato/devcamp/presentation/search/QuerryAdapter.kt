package com.psato.devcamp.presentation.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.psato.devcamp.R
import com.psato.devcamp.infrastructure.bindView
import com.psato.devcamp.infrastructure.databind.AdapterViewModel
import com.psato.devcamp.infrastructure.databind.LifeCycleAdapter
import com.psato.devcamp.infrastructure.databind.LifeCycleViewHolder
import com.psato.devcamp.infrastructure.databind.text


class QuerryAdapter(private val viewModel: AdapterViewModel<ShowResponseItem>) : LifeCycleAdapter<QuerryAdapter.SearchViewHolder>() {

    override fun onBindViewHolderImpl(holder: SearchViewHolder, position: Int) {
        holder.bindView(viewModel.getItemAtPosition(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.show_item, parent, false)
        return SearchViewHolder(v)
    }

    override fun getItemCount(): Int {
        return viewModel.getItemsCount()
    }

    class SearchViewHolder(itemView: View?) : LifeCycleViewHolder(itemView) {
        val showName: TextView by bindView(R.id.show_name)
        fun bindView(item: ShowResponseItem) {
            showName.text(item.showName, this)
        }
    }

}