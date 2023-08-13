package com.rodriguesporan.uilists.domain.repository

import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO

internal interface GitHubRepositoriesRepository {
    suspend fun fetchRepositories(): List<GitHubRepositoryDTO>
}
