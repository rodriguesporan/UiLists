package com.rodriguesporan.uilists.domain.repository

import com.rodriguesporan.uilists.domain.model.Affirmation

internal interface AffirmationRepository {
    fun getAffirmations(): List<Affirmation>
}
