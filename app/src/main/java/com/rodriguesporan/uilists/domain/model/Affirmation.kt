package com.rodriguesporan.uilists.domain.model

import android.graphics.Bitmap

internal data class Affirmation(
    val id: Int,
    val title: String,
    val description: String? = null,
    val image: Bitmap? = null
)
