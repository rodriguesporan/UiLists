package com.rodriguesporan.uilists.domain

import com.rodriguesporan.uilists.model.CardMessage

internal interface CustomDataItemUseCase {
    fun getItems(counter: Int): List<CardMessage>
}
