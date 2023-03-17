package com.rodriguesporan.uilists.data

import com.rodriguesporan.uilists.model.CardMessage

internal class CardMessageDatasource {

    fun listCardsUntil(lastIndex: Int): List<CardMessage> {
        return (1..lastIndex).map {
            CardMessage(
                title = "$TITLE$it",
                description = DESCRIPTION
            )
        }
    }
}

private const val TITLE = "Title number #"
private const val DESCRIPTION = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
