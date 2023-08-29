package com.rodriguesporan.uilists.domain.usecase

import com.rodriguesporan.uilists.data.model.RepositoriesDTO
import com.rodriguesporan.uilists.domain.repository.RepositoriesRepository

internal class FetchRepositoriesUseCase(
    private val repository: RepositoriesRepository
) {
    suspend operator fun invoke(): RepositoriesDTO {
        return repository.fetchRepositories()
    }
}
