package com.rodriguesporan.uilists.data.repository

import com.rodriguesporan.uilists.data.datasource.GitHubAuthenticationRemoteDataSource
import com.rodriguesporan.uilists.data.model.UserTokenRequestParams
import com.rodriguesporan.uilists.data.model.GitHubUserTokenDTO
import com.rodriguesporan.uilists.domain.repository.GitHubAuthenticationRepository

internal class GitHubAuthenticationRepositoryImpl(
    private val dataSource: GitHubAuthenticationRemoteDataSource
) : GitHubAuthenticationRepository {

    override suspend fun fetchUserToken(request: UserTokenRequestParams): GitHubUserTokenDTO {
        return dataSource.fetchUserToken(request)
    }
}
