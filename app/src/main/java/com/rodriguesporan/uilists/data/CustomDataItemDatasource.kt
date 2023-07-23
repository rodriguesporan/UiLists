package com.rodriguesporan.uilists.data

import com.rodriguesporan.uilists.domain.usecase.CustomDataItemUseCase
import com.rodriguesporan.uilists.domain.model.CardMessage

internal class CustomDataItemDatasource: CustomDataItemUseCase {

    override fun getItems(counter: Int): List<CardMessage> {
        val lastId = counter - 1
        return (0..lastId).map { id -> CardMessage(id) }
    }
}
