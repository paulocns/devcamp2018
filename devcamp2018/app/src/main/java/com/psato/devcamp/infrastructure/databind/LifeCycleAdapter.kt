package com.psato.devcamp.infrastructure.databind

import android.support.v7.widget.RecyclerView

abstract class LifeCycleAdapter<VH : LifeCycleViewHolder> : RecyclerView.Adapter<VH>() {

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.notifyBindViewHolder()
        onBindViewHolderImpl(holder, position)
    }

    protected abstract fun onBindViewHolderImpl(holder: VH, position: Int);


    override fun onViewRecycled(holder: VH) {
        super.onViewRecycled(holder)
        holder.notifyUnbindViewHolder()
    }
}