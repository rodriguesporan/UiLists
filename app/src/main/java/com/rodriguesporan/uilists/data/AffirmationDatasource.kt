package com.rodriguesporan.uilists.presentation

import com.rodriguesporan.uilists.model.Affirmation

internal class AffirmationDatasource {

    fun listAffirmationsUntil(lastIndex: Int): List<Affirmation> {
        return (1..lastIndex).map { Affirmation("$AFFIRMATION_TEXT$it") }
    }
}

private const val AFFIRMATION_TEXT = "Affirmation number #"
