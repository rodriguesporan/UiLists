package com.rodriguesporan.uilists.data.repository

import com.rodriguesporan.uilists.data.datasource.AuthenticationDataSource
import com.rodriguesporan.uilists.data.model.UserTokenDTO
import com.rodriguesporan.uilists.data.model.UserTokenRequestParams
import com.rodriguesporan.uilists.domain.repository.AuthenticationRepository

internal class AuthenticationRepositoryImpl(
    private val dataSource: AuthenticationDataSource
) : AuthenticationRepository {

    override suspend fun fetchUserToken(request: UserTokenRequestParams): UserTokenDTO {
        return dataSource.fetchUserToken(request)
    }
}
