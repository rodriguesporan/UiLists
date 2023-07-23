package com.rodriguesporan.uilists.data

import com.rodriguesporan.uilists.domain.usecase.SimpleDataItemUseCase
import com.rodriguesporan.uilists.domain.model.Affirmation

internal class SimpleDataItemDatasource: SimpleDataItemUseCase {

    override fun getItems(counter: Int): List<Affirmation> {
        val lastId = counter - 1
        return (0..lastId).map { id -> Affirmation(id) }
    }
}
