package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.domain.model.Affirmation

internal class SimpleAffirmationDatasource : AffirmationDatasource {

    override fun getItems(): List<Affirmation> {
        return (0..99).map { id -> Affirmation(id = id, title = "$AFFIRMATION_TEXT$id") }
    }

    companion object {
        private const val AFFIRMATION_TEXT = "Affirmation id #"
    }
}
