package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.data.api.AuthenticationApi
import com.rodriguesporan.uilists.data.model.UserTokenRequestParams
import com.rodriguesporan.uilists.data.model.GitHubUserTokenDTO
import com.rodriguesporan.uilists.di.factories.AuthenticationApiServiceFactory

internal class GitHubAuthenticationRemoteDataSource(
    apiFactory: AuthenticationApiServiceFactory
): GitHubAuthenticationDataSource<AuthenticationApi>(apiFactory) {

    override suspend fun fetchUserToken(request: UserTokenRequestParams): GitHubUserTokenDTO {
        val userTokenQueryMap: Map<String, String> = mutableMapOf(
            "client_id" to request.clientId,
            "client_secret" to request.clientSecret,
            "code" to request.code,
            "redirect_uri" to request.redirectUri,
        )
        request.repositoryId?.let { repositoryId ->
            userTokenQueryMap.plus("repository_id" to repositoryId)
        }
        return apiFactory.create().fetchUserToken(userTokenQueryMap)
    }
}
