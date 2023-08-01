package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.data.api.AuthenticationApi
import com.rodriguesporan.uilists.data.model.UserTokenRequestParams
import com.rodriguesporan.uilists.data.model.GitHubUserTokenDTO

internal class GitHubAuthenticationRemoteDataSource(
    private val api: AuthenticationApi
) {

    suspend fun fetchUserToken(request: UserTokenRequestParams): GitHubUserTokenDTO {
        val userTokenQueryMap: Map<String, String> = mutableMapOf(
            "client_id" to request.clientId,
            "client_secret" to request.clientSecret,
            "code" to request.code,
            "redirect_uri" to request.redirectUri,
        )
        request.repositoryId?.let { repositoryId ->
            userTokenQueryMap.plus("repository_id" to repositoryId)
        }
        return api.fetchUserToken(userTokenQueryMap)
    }
}
