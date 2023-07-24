package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.domain.model.Affirmation

internal interface AffirmationDataSource {
    fun getItems(): List<Affirmation>
}
