package com.rodriguesporan.uilists.domain.usecase

import com.rodriguesporan.uilists.domain.model.Affirmation
import com.rodriguesporan.uilists.domain.repository.AffirmationRepository

internal class GetAffirmationsUseCase(
    private val repository: AffirmationRepository
) {
    operator fun invoke(): List<Affirmation> {
        return repository.getAffirmations()
    }
}
