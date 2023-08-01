package com.rodriguesporan.uilists.data.repository

import com.rodriguesporan.uilists.data.datasource.GitHubRepositoryDataSource
import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO
import com.rodriguesporan.uilists.domain.repository.GitHubRepositoryRepository

internal class GitHubRepositoryRepositoryImpl(
    private val dataSource: GitHubRepositoryDataSource
): GitHubRepositoryRepository {

    override suspend fun fetchRepositories(): List<GitHubRepositoryDTO> {
        return dataSource.fetchRepositories()
    }
}
