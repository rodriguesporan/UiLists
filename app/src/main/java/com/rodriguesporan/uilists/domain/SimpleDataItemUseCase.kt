package com.rodriguesporan.uilists.domain

import com.rodriguesporan.uilists.model.Affirmation

internal interface SimpleDataItemUseCase {
    fun getItems(counter: Int): List<Affirmation>
}
