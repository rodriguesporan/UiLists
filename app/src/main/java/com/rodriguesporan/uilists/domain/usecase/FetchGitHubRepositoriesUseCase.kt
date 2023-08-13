package com.rodriguesporan.uilists.domain.usecase

import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO
import com.rodriguesporan.uilists.domain.repository.GitHubRepositoriesRepository

internal class FetchGitHubRepositoriesUseCase(
    private val repository: GitHubRepositoriesRepository
) {
    suspend operator fun invoke(): List<GitHubRepositoryDTO> {
        return repository.fetchRepositories()
    }
}
