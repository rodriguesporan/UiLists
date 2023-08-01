package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO

internal interface GitHubRepositoryDataSource {

    suspend fun fetchRepositories(): List<GitHubRepositoryDTO>
}
