package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.data.api.RepositoriesApi
import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO

internal class GitHubRepositoriesRemoteDataSource(
    private val api: RepositoriesApi
): GitHubRepositoriesDataSource {

    override suspend fun fetchRepositories(): List<GitHubRepositoryDTO> {
        return api.fetchRepositories()
    }
}
