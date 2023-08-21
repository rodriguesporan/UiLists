package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.data.api.RepositoriesApi
import com.rodriguesporan.uilists.data.model.RepositoryDTO

internal abstract class RepositoriesDataSource(
//    protected val apiFactory: ApiServiceFactory<T>
    protected val api: RepositoriesApi
) {
    abstract suspend fun fetchRepositories(): List<RepositoryDTO>
}
