package com.rodriguesporan.uilists.domain.repository

import com.rodriguesporan.uilists.data.model.UserTokenRequestParams
import com.rodriguesporan.uilists.data.model.GitHubUserTokenDTO

internal interface GitHubAuthenticationRepository {
    suspend fun fetchUserToken(request: UserTokenRequestParams): GitHubUserTokenDTO
}
