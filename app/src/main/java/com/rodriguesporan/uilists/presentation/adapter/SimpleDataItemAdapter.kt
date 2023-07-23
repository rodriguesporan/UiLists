package com.rodriguesporan.uilists.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.presentation.holder.AffirmationViewHolder
import com.rodriguesporan.uilists.domain.model.Affirmation

internal class SimpleDataItemAdapter(
    private val affirmationsDataset: List<Affirmation>
): RecyclerView.Adapter<AffirmationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AffirmationViewHolder {
        val itemView: View = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.activity_simple_data_item_linear_fixed_data_set_list_item,
                parent,
                false
            )
        return AffirmationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AffirmationViewHolder, position: Int) {
        holder.bind(affirmationsDataset[position])
    }

    override fun getItemCount(): Int {
        println("Size> ${affirmationsDataset.size}")
        return affirmationsDataset.size
    }
}
