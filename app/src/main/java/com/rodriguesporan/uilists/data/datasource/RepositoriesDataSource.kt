package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.data.api.RepositoriesApi
import com.rodriguesporan.uilists.data.model.RepositoriesDTO

internal abstract class RepositoriesDataSource(
    protected val api: RepositoriesApi
) {
    abstract suspend fun fetchRepositories(): RepositoriesDTO
}
