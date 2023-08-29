package com.rodriguesporan.uilists.presentation.mapper

import com.rodriguesporan.uilists.data.model.RepositoryDTO
import com.rodriguesporan.uilists.presentation.model.DataView

internal object DataViewMapper {
    fun convertFromRepositoryDTO(repository: RepositoryDTO): DataView {
        return if (repository.description == null) {
            DataView.SingleLabel(
                title = repository.name
            )
        } else {
            DataView.DoubleLabel(
                title = repository.name,
                description = repository.description
            )
        }
    }
}
