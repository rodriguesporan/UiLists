package com.rodriguesporan.uilists.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.presentation.holder.DoubleLabelViewHolder
import com.rodriguesporan.uilists.presentation.holder.SingleLabelViewHolder
import com.rodriguesporan.uilists.presentation.model.DataView
import com.rodriguesporan.uilists.presentation.model.DataView.SingleLabel
import com.rodriguesporan.uilists.presentation.model.DataView.DoubleLabel

internal class DataViewAdapter(
    private val dataset: List<DataView>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.simple_label_list_item -> SingleLabelViewHolder(parent.inflate(viewType))
            else -> DoubleLabelViewHolder(parent.inflate(viewType))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SingleLabelViewHolder -> holder.bind(dataset[position] as SingleLabel)
            is DoubleLabelViewHolder -> holder.bind(dataset[position] as DoubleLabel)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun getItemViewType(position: Int): Int {
        return dataset[position].layoutRes
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }
}
