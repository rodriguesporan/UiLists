package com.rodriguesporan.uilists.data.api

import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO
import retrofit2.http.GET

internal interface RepositoriesApi {

    @GET(GITHUB_LIST_PUBLIC_REPOSITORIES_PATH)
    suspend fun fetchRepositories(): List<GitHubRepositoryDTO>

    companion object {
        private const val GITHUB_LIST_PUBLIC_REPOSITORIES_PATH = "repositories"
    }
}
