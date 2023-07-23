package com.rodriguesporan.uilists.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.holder.CardMessageViewHolder
import com.rodriguesporan.uilists.model.CardMessage

internal class CustomDataItemAdapter(
    private val cards: List<CardMessage>
) : RecyclerView.Adapter<CardMessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardMessageViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.activity_custom_data_item_linear_fixed_data_set_list_item,
                parent,
                false
            )
        return CardMessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardMessageViewHolder, position: Int) {
        holder.bind(cards[position])
    }

    override fun getItemCount(): Int {
        return cards.size
    }
}
