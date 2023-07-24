package com.rodriguesporan.uilists.data.repository

import com.rodriguesporan.uilists.data.datasource.AffirmationDataSource
import com.rodriguesporan.uilists.domain.model.Affirmation
import com.rodriguesporan.uilists.domain.repository.AffirmationRepository

internal class AffirmationRepositoryImpl(
    private val datasource: AffirmationDataSource
): AffirmationRepository {
    override fun getAffirmations(): List<Affirmation> {
        return datasource.getItems()
    }
}
