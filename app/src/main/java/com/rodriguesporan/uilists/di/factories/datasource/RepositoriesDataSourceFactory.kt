package com.rodriguesporan.uilists.di.factories.datasource

import com.rodriguesporan.uilists.data.api.RepositoriesApi
import com.rodriguesporan.uilists.data.datasource.RepositoriesDataSource
import com.rodriguesporan.uilists.data.datasource.RepositoriesRemoteDataSource
import com.rodriguesporan.uilists.di.factories.api.ApiServiceFactory

internal class RepositoriesDataSourceFactory(
    private val apiServiceFactory: ApiServiceFactory<RepositoriesApi>
) : DataSourceFactory<RepositoriesDataSource>() {
    override fun create(): RepositoriesDataSource {
        return RepositoriesRemoteDataSource(api = apiServiceFactory.create())
    }
}
