package com.rodriguesporan.uilists.domain.repository

import com.rodriguesporan.uilists.data.model.RepositoriesDTO

internal interface RepositoriesRepository {
    suspend fun fetchRepositories(): RepositoriesDTO
}
