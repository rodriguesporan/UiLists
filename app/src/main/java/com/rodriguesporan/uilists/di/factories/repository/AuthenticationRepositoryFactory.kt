package com.rodriguesporan.uilists.di.factories.repository

import com.rodriguesporan.uilists.data.datasource.AuthenticationDataSource
import com.rodriguesporan.uilists.data.repository.AuthenticationRepositoryImpl
import com.rodriguesporan.uilists.di.factories.datasource.DataSourceFactory
import com.rodriguesporan.uilists.domain.repository.AuthenticationRepository

internal class AuthenticationRepositoryFactory(
    private val dataSourceFactory: DataSourceFactory<AuthenticationDataSource>
): RepositoryFactory<AuthenticationRepository>() {
    override fun create(): AuthenticationRepository {
        return AuthenticationRepositoryImpl(dataSourceFactory.create())
    }
}
