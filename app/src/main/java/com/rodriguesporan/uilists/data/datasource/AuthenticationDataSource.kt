package com.rodriguesporan.uilists.data.datasource

import com.rodriguesporan.uilists.data.api.AuthenticationApi
import com.rodriguesporan.uilists.data.model.UserTokenDTO
import com.rodriguesporan.uilists.data.model.UserTokenRequestParams

internal abstract class AuthenticationDataSource(
    protected val api: AuthenticationApi
) {
    abstract suspend fun fetchUserToken(request: UserTokenRequestParams): UserTokenDTO
}
