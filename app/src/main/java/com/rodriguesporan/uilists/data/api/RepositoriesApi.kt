package com.rodriguesporan.uilists.data.api

import com.rodriguesporan.uilists.data.model.RepositoryDTO
import retrofit2.http.GET

internal interface RepositoriesApi {

    @GET(LIST_PUBLIC_REPOSITORIES_PATH)
    suspend fun fetchRepositories(): List<RepositoryDTO>

    companion object {
        private const val LIST_PUBLIC_REPOSITORIES_PATH = "repositories"
    }
}
