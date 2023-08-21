package com.rodriguesporan.uilists.domain.repository

import com.rodriguesporan.uilists.data.model.UserTokenRequestParams
import com.rodriguesporan.uilists.data.model.UserTokenDTO

internal interface AuthenticationRepository {
    suspend fun fetchUserToken(request: UserTokenRequestParams): UserTokenDTO
}
