package com.rodriguesporan.uilists.domain.usecase

import com.rodriguesporan.uilists.data.model.UserTokenRequestParams
import com.rodriguesporan.uilists.data.model.GitHubUserTokenDTO
import com.rodriguesporan.uilists.domain.repository.GitHubAuthenticationRepository

internal class FetchGitHubUserTokenUseCase(
    private val repository: GitHubAuthenticationRepository
) {
    suspend operator fun invoke(request: UserTokenRequestParams): GitHubUserTokenDTO {
        return repository.fetchUserToken(request)
    }
}
