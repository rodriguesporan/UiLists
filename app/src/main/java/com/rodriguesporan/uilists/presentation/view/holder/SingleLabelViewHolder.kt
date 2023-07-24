package com.rodriguesporan.uilists.presentation.view.holder

import android.view.View
import com.rodriguesporan.uilists.presentation.model.DataView

internal class SingleLabelViewHolder(
    itemView: View
) : BaseViewHolder<DataView.SingleLabel>(itemView) {

    override fun bind(data: DataView.SingleLabel) {
        super.setupViews(data)
    }
}
