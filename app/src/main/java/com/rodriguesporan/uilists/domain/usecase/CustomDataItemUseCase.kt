package com.rodriguesporan.uilists.domain.usecase

import com.rodriguesporan.uilists.domain.model.CardMessage

internal interface CustomDataItemUseCase {
    fun getItems(counter: Int): List<CardMessage>
}