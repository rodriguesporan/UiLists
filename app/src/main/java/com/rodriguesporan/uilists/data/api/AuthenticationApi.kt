package com.rodriguesporan.uilists.data.api

import com.rodriguesporan.uilists.data.model.GitHubUserTokenDTO
import retrofit2.http.POST
import retrofit2.http.QueryMap

internal interface AuthenticationApi {

    @POST(GITHUB_LOGIN_OAUTH_ACCESS_TOKEN_PATH)
    suspend fun fetchUserToken(
        @QueryMap requestQueryMap: Map<String, String>
    ): GitHubUserTokenDTO

    companion object {
        private const val GITHUB_LOGIN_OAUTH_ACCESS_TOKEN_PATH = "auth/token"
    }
}
