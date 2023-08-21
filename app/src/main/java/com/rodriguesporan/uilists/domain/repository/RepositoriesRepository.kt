package com.rodriguesporan.uilists.domain.repository

import com.rodriguesporan.uilists.data.model.RepositoryDTO

internal interface RepositoriesRepository {
    suspend fun fetchRepositories(): List<RepositoryDTO>
}
