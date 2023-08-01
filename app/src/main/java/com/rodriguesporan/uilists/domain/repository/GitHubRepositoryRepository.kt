package com.rodriguesporan.uilists.domain.repository

import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO

internal interface GitHubRepositoryRepository {
    suspend fun fetchRepositories(): List<GitHubRepositoryDTO>
}
