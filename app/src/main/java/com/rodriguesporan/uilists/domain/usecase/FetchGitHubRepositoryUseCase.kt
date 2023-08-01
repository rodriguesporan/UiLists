package com.rodriguesporan.uilists.domain.usecase

import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO
import com.rodriguesporan.uilists.domain.repository.GitHubRepositoryRepository

internal class FetchGitHubRepositoryUseCase(
    private val repository: GitHubRepositoryRepository
) {
    suspend operator fun invoke(): List<GitHubRepositoryDTO> {
        return repository.fetchRepositories()
    }
}
