package com.rodriguesporan.uilists.presentation.holder

import android.view.View
import android.widget.ImageView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.presentation.model.DataView

internal class UserAvatarViewHolder(
    itemView: View
) : BaseViewHolder<DataView.UserImage>(itemView) {
    private val imageViewUserAvatar: ImageView

    init {
        imageViewUserAvatar = itemView.findViewById(R.id.image_view_user_avatar)
    }

    override fun bind(data: DataView.UserImage) {
        super.setupViews(data)
    }
}
