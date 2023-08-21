package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO
import com.rodriguesporan.uilists.di.factories.ApiServiceFactory

internal abstract class GitHubRepositoriesDataSource<T>(
    protected val apiFactory: ApiServiceFactory<T>
) {
    abstract suspend fun fetchRepositories(): List<GitHubRepositoryDTO>
}
