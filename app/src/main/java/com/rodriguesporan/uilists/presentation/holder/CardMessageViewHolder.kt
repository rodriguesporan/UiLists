package com.rodriguesporan.uilists.presentation.holder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.domain.model.CardMessage

internal class CardMessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val titleTextView: AppCompatTextView
    private val descriptionTextView: AppCompatTextView

    init {
        titleTextView = itemView.findViewById(R.id.text_view_title)
        descriptionTextView = itemView.findViewById(R.id.text_view_description)
    }

    fun bind(data: CardMessage) {
        titleTextView.text = data.title
        descriptionTextView.text = data.description
    }
}
