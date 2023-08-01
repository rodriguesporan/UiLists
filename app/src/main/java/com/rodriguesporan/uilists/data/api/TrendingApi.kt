package com.rodriguesporan.uilists.data.api

import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

internal interface TrendingApi {

    @Headers(
        HEADER_GITHUB_API_VERSION,
        HEADER_ACCEPT_APPLICATION_VND_GITHUB_JSON
    )
    @GET(GITHUB_LIST_PUBLIC_REPOSITORIES_PATH)
    suspend fun fetchRepositories(
        @Header("Authorization") authorization: String
    ): List<GitHubRepositoryDTO>

    companion object {
        private const val HEADER_GITHUB_API_VERSION = "X-GitHub-Api-Version: 2022-11-28"
        private const val HEADER_ACCEPT_APPLICATION_VND_GITHUB_JSON = "Accept: application/vnd.github+json"
        private const val GITHUB_LIST_PUBLIC_REPOSITORIES_PATH = "repositories"
    }
}
