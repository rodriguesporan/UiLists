package com.rodriguesporan.uilists.domain.usecase

import com.rodriguesporan.uilists.domain.model.Affirmation

internal interface SimpleDataItemUseCase {
    fun getItems(counter: Int): List<Affirmation>
}