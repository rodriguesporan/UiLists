package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.data.api.TrendingApi
import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO

internal class GitHubRepositoryRemoteDataSource(
    private val api: TrendingApi
): GitHubRepositoryDataSource {

    override suspend fun fetchRepositories(): List<GitHubRepositoryDTO> {
        return api.fetchRepositories("Bearer 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")
    }
}
