package com.rodriguesporan.uilists.domain.usecase

import com.rodriguesporan.uilists.data.model.UserTokenRequestParams
import com.rodriguesporan.uilists.data.model.UserTokenDTO
import com.rodriguesporan.uilists.domain.repository.AuthenticationRepository

internal class FetchUserTokenUseCase(
    private val repository: AuthenticationRepository
) {
    suspend operator fun invoke(request: UserTokenRequestParams): UserTokenDTO {
        return repository.fetchUserToken(request)
    }
}
