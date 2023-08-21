package com.rodriguesporan.uilists.di.factories.repository

import com.rodriguesporan.uilists.data.datasource.RepositoriesDataSource
import com.rodriguesporan.uilists.data.repository.RepositoriesRepositoryImpl
import com.rodriguesporan.uilists.di.factories.datasource.DataSourceFactory
import com.rodriguesporan.uilists.domain.repository.RepositoriesRepository

internal class RepositoriesRepositoryFactory(
    private val dataSourceFactory: DataSourceFactory<RepositoriesDataSource>
): RepositoryFactory<RepositoriesRepository>() {
    override fun create(): RepositoriesRepository {
        return RepositoriesRepositoryImpl(dataSourceFactory.create())
    }
}
