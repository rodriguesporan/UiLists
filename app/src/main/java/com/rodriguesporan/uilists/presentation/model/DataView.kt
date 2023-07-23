package com.rodriguesporan.uilists.presentation.model

import android.graphics.Bitmap
import androidx.annotation.LayoutRes
import com.rodriguesporan.uilists.R

internal sealed class DataView(
    open val title: String,
    @LayoutRes val layoutRes: Int
) {
    data class SingleLabel(
        override val title: String
    ) : DataView(title, R.layout.simple_label_list_item)

    data class DoubleLabel(
        override val title: String,
        val description: String
    ) : DataView(title, R.layout.double_label_list_item)

    data class BrandImage(
        override val title: String,
        val image: Bitmap
    ) : DataView(title, 0)
}
