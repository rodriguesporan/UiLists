package com.rodriguesporan.uilists.domain.usecase

import com.rodriguesporan.uilists.data.model.RepositoryDTO
import com.rodriguesporan.uilists.domain.repository.RepositoriesRepository

internal class FetchRepositoriesUseCase(
    private val repository: RepositoriesRepository
) {
    suspend operator fun invoke(): List<RepositoryDTO> {
        return repository.fetchRepositories()
    }
}
