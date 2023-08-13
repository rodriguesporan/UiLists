package com.rodriguesporan.uilists.presentation.holder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.presentation.model.DataView

internal class DoubleLabelViewHolder(
    itemView: View
) : BaseViewHolder<DataView.DoubleLabel>(itemView) {

    private val descriptionTextView: AppCompatTextView

    init {
        descriptionTextView = itemView.findViewById(R.id.text_view_description)
    }

    override fun bind(data: DataView.DoubleLabel) {
        super.setupViews(data)
        descriptionTextView.text = data.description
    }
}
