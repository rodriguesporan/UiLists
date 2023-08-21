package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.data.api.RepositoriesApi
import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO
import com.rodriguesporan.uilists.di.factories.RepositoriesApiServiceFactory

internal class GitHubRepositoriesRemoteDataSource(
    apiFactory: RepositoriesApiServiceFactory
): GitHubRepositoriesDataSource<RepositoriesApi>(apiFactory) {

    override suspend fun fetchRepositories(): List<GitHubRepositoryDTO> {
        return apiFactory.create().fetchRepositories()
    }
}
