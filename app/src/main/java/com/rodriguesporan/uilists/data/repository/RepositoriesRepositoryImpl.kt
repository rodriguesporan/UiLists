package com.rodriguesporan.uilists.data.repository

import com.rodriguesporan.uilists.data.datasource.RepositoriesDataSource
import com.rodriguesporan.uilists.data.model.RepositoryDTO
import com.rodriguesporan.uilists.domain.repository.RepositoriesRepository

internal class RepositoriesRepositoryImpl(
    private val dataSource: RepositoriesDataSource
): RepositoriesRepository {

    override suspend fun fetchRepositories(): List<RepositoryDTO> {
        return dataSource.fetchRepositories()
    }
}
