package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.domain.model.Affirmation

internal interface AffirmationDatasource {
    fun getItems(): List<Affirmation>
}
