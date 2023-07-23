package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.domain.model.Affirmation

internal class CustomAffirmationDatasource : AffirmationDatasource {

    override fun getItems(): List<Affirmation> {
        return (0..9).map { id ->
            Affirmation(
                id = id,
                title = "$AFFIRMATION_TEXT$id",
                description = DESCRIPTION
            )
        }
    }

    companion object {
        private const val AFFIRMATION_TEXT = "Affirmation id #"
        private const val DESCRIPTION =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

    }
}
