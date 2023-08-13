package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO

internal interface GitHubRepositoriesDataSource {

    suspend fun fetchRepositories(): List<GitHubRepositoryDTO>
}
