package com.rodriguesporan.uilists.model

internal data class Affirmation(
    val id: Int
) {
    val text: String
        get() = "$AFFIRMATION_TEXT$id"
}

private const val AFFIRMATION_TEXT = "Affirmation id #"
