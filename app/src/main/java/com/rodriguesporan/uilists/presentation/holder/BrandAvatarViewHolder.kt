package com.rodriguesporan.uilists.presentation.holder

import android.view.View
import android.widget.ImageView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.presentation.model.DataView

internal class BrandAvatarViewHolder(
    itemView: View
) : BaseViewHolder<DataView.BrandImage>(itemView) {
    private val imageViewBrandAvatar: ImageView

    init {
        imageViewBrandAvatar = itemView.findViewById(R.id.image_view_brand_avatar)
    }

    override fun bind(data: DataView.BrandImage) {
        super.setupViews(data)
    }
}
