package com.rodriguesporan.uilists.di

import android.content.Context
import com.rodriguesporan.uilists.data.api.AuthenticationApi
import com.rodriguesporan.uilists.data.api.RepositoriesApi
import com.rodriguesporan.uilists.data.datasource.AuthenticationDataSource
import com.rodriguesporan.uilists.data.datasource.CustomAffirmationDataSource
import com.rodriguesporan.uilists.data.datasource.RepositoriesDataSource
import com.rodriguesporan.uilists.data.datasource.SimpleAffirmationDataSource
import com.rodriguesporan.uilists.data.repository.AffirmationRepositoryImpl
import com.rodriguesporan.uilists.di.factories.api.ApiServiceFactory
import com.rodriguesporan.uilists.di.factories.api.AuthenticationApiServiceFactory
import com.rodriguesporan.uilists.di.factories.api.RepositoriesApiServiceFactory
import com.rodriguesporan.uilists.di.factories.datasource.AuthenticationDataSourceFactory
import com.rodriguesporan.uilists.di.factories.datasource.DataSourceFactory
import com.rodriguesporan.uilists.di.factories.datasource.RepositoriesDataSourceFactory
import com.rodriguesporan.uilists.di.factories.repository.AuthenticationRepositoryFactory
import com.rodriguesporan.uilists.di.factories.repository.RepositoriesRepositoryFactory
import com.rodriguesporan.uilists.di.factories.repository.RepositoryFactory
import com.rodriguesporan.uilists.di.factories.usecase.FetchRepositoriesUseCaseFactory
import com.rodriguesporan.uilists.di.factories.usecase.FetchUserTokenUseCaseFactory
import com.rodriguesporan.uilists.di.factories.usecase.UseCaseFactory
import com.rodriguesporan.uilists.di.session.SessionProvider
import com.rodriguesporan.uilists.di.session.SessionProviderImpl
import com.rodriguesporan.uilists.domain.repository.AuthenticationRepository
import com.rodriguesporan.uilists.domain.repository.RepositoriesRepository
import com.rodriguesporan.uilists.domain.usecase.FetchRepositoriesUseCase
import com.rodriguesporan.uilists.domain.usecase.FetchUserTokenUseCase
import com.rodriguesporan.uilists.domain.usecase.GetAffirmationsUseCase

internal class AppContainer(
    context: Context
) {
    val session: SessionProvider = SessionProviderImpl(context)

    private val authenticationApiServiceFactory: ApiServiceFactory<AuthenticationApi> =
        AuthenticationApiServiceFactory(session = session)
    private val repositoriesApiServiceFactory: ApiServiceFactory<RepositoriesApi> =
        RepositoriesApiServiceFactory(session = session)

    private val authenticationDataSourceFactory: DataSourceFactory<AuthenticationDataSource> =
        AuthenticationDataSourceFactory(authenticationApiServiceFactory)
    private val repositoriesDataSourceFactory: DataSourceFactory<RepositoriesDataSource> =
        RepositoriesDataSourceFactory(repositoriesApiServiceFactory)

    private val authenticationRepositoryFactory: RepositoryFactory<AuthenticationRepository> =
        AuthenticationRepositoryFactory(authenticationDataSourceFactory)
    private val repositoriesRepositoryFactory: RepositoryFactory<RepositoriesRepository> =
        RepositoriesRepositoryFactory(repositoriesDataSourceFactory)

    val fetchUserTokenUseCaseFactory: UseCaseFactory<FetchUserTokenUseCase> =
        FetchUserTokenUseCaseFactory(authenticationRepositoryFactory)
    val fetchRepositoriesUseCaseFactory: UseCaseFactory<FetchRepositoriesUseCase> =
        FetchRepositoriesUseCaseFactory(repositoriesRepositoryFactory)

    val getSimpleAffirmationsUseCase =
        GetAffirmationsUseCase(AffirmationRepositoryImpl(SimpleAffirmationDataSource()))
    val getCustomAffirmationsUseCase =
        GetAffirmationsUseCase(AffirmationRepositoryImpl(CustomAffirmationDataSource()))
}
