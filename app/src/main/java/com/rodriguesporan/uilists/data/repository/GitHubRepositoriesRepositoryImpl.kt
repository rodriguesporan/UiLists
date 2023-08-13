package com.rodriguesporan.uilists.data.repository

import com.rodriguesporan.uilists.data.datasource.GitHubRepositoriesDataSource
import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO
import com.rodriguesporan.uilists.domain.repository.GitHubRepositoriesRepository

internal class GitHubRepositoriesRepositoryImpl(
    private val dataSource: GitHubRepositoriesDataSource
): GitHubRepositoriesRepository {

    override suspend fun fetchRepositories(): List<GitHubRepositoryDTO> {
        return dataSource.fetchRepositories()
    }
}
