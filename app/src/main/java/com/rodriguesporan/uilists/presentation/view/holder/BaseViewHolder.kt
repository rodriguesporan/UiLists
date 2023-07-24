package com.rodriguesporan.uilists.presentation.view.holder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.presentation.model.DataView

internal abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textView: AppCompatTextView

    init {
        textView = itemView.findViewById(R.id.text_view_title)
    }

    abstract fun bind(data: T)

    protected fun setupViews(data: DataView) {
        textView.text = data.title
    }
}
