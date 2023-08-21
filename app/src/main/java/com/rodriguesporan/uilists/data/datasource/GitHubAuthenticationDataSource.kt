package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.data.model.GitHubUserTokenDTO
import com.rodriguesporan.uilists.data.model.UserTokenRequestParams
import com.rodriguesporan.uilists.di.factories.ApiServiceFactory

internal abstract class GitHubAuthenticationDataSource<T>(
    protected val apiFactory: ApiServiceFactory<T>
) {
    abstract suspend fun fetchUserToken(request: UserTokenRequestParams): GitHubUserTokenDTO
}
