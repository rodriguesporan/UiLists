package com.rodriguesporan.uilists.data.repository

import com.rodriguesporan.uilists.data.datasource.RepositoriesDataSource
import com.rodriguesporan.uilists.data.model.RepositoriesDTO
import com.rodriguesporan.uilists.domain.repository.RepositoriesRepository

internal class RepositoriesRepositoryImpl(
    private val dataSource: RepositoriesDataSource
): RepositoriesRepository {

    override suspend fun fetchRepositories(): RepositoriesDTO {
        return dataSource.fetchRepositories()
    }
}
