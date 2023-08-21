package com.rodriguesporan.uilists.di.factories.datasource

import com.rodriguesporan.uilists.data.api.AuthenticationApi
import com.rodriguesporan.uilists.data.datasource.AuthenticationDataSource
import com.rodriguesporan.uilists.data.datasource.AuthenticationRemoteDataSource
import com.rodriguesporan.uilists.di.factories.api.ApiServiceFactory

internal class AuthenticationDataSourceFactory(
    private val apiServiceFactory: ApiServiceFactory<AuthenticationApi>
) : DataSourceFactory<AuthenticationDataSource>() {
    override fun create(): AuthenticationDataSource {
        return AuthenticationRemoteDataSource(api = apiServiceFactory.create())
    }
}
