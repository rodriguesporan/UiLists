package com.rodriguesporan.uilists.presentation.holder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.domain.model.Affirmation

internal class AffirmationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textView: AppCompatTextView

    init {
        textView = itemView.findViewById(R.id.text_view)
    }

    fun bind(data: Affirmation) {
        textView.text = data.text
    }
}
