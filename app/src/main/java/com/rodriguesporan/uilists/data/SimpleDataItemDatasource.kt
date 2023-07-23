package com.rodriguesporan.uilists.data

import com.rodriguesporan.uilists.model.Affirmation

internal class AffirmationDatasource {

    fun listAffirmations(counter: Int): List<Affirmation> {
        val lastId = counter - 1
        return (0..lastId).map { id -> Affirmation(id) }
    }
}
