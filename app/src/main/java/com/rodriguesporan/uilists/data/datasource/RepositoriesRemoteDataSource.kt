package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.data.api.RepositoriesApi
import com.rodriguesporan.uilists.data.model.RepositoriesDTO

internal class RepositoriesRemoteDataSource(
    api: RepositoriesApi
) : RepositoriesDataSource(api) {

    override suspend fun fetchRepositories(): RepositoriesDTO {
        return api.fetchRepositories()
    }
}
