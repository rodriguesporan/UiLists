package com.rodriguesporan.uilists.data

import com.rodriguesporan.uilists.domain.CustomUseCase
import com.rodriguesporan.uilists.model.CardMessage

internal class CardMessageDatasource: CustomUseCase {

    override fun listCards(counter: Int): List<CardMessage> {
        val lastId = counter - 1
        return (0..lastId).map { id -> CardMessage(id) }
    }
}
