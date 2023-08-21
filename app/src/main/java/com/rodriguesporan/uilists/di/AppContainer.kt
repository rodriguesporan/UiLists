package com.rodriguesporan.uilists.di

import android.content.Context
import com.rodriguesporan.uilists.data.api.AuthenticationApi
import com.rodriguesporan.uilists.data.api.RepositoriesApi
import com.rodriguesporan.uilists.data.datasource.CustomAffirmationDataSource
import com.rodriguesporan.uilists.data.datasource.GitHubAuthenticationDataSource
import com.rodriguesporan.uilists.data.datasource.GitHubAuthenticationRemoteDataSource
import com.rodriguesporan.uilists.data.datasource.GitHubRepositoriesDataSource
import com.rodriguesporan.uilists.data.datasource.GitHubRepositoriesRemoteDataSource
import com.rodriguesporan.uilists.data.datasource.SimpleAffirmationDataSource
import com.rodriguesporan.uilists.data.repository.AffirmationRepositoryImpl
import com.rodriguesporan.uilists.data.repository.GitHubAuthenticationRepositoryImpl
import com.rodriguesporan.uilists.data.repository.GitHubRepositoriesRepositoryImpl
import com.rodriguesporan.uilists.di.factories.AuthenticationApiServiceFactory
import com.rodriguesporan.uilists.di.factories.RepositoriesApiServiceFactory
import com.rodriguesporan.uilists.di.session.SessionProvider
import com.rodriguesporan.uilists.di.session.SessionProviderImpl
import com.rodriguesporan.uilists.domain.repository.GitHubAuthenticationRepository
import com.rodriguesporan.uilists.domain.repository.GitHubRepositoriesRepository
import com.rodriguesporan.uilists.domain.usecase.FetchGitHubRepositoriesUseCase
import com.rodriguesporan.uilists.domain.usecase.FetchGitHubUserTokenUseCase
import com.rodriguesporan.uilists.domain.usecase.GetAffirmationsUseCase

internal class AppContainer(
    context: Context
) {
    val session: SessionProvider = SessionProviderImpl(context)

    private val gitHubAuthenticationDataSource: GitHubAuthenticationDataSource<AuthenticationApi> =
        GitHubAuthenticationRemoteDataSource(AuthenticationApiServiceFactory(session = session))
    private val gitHubRepositoriesDataSource: GitHubRepositoriesDataSource<RepositoriesApi> =
        GitHubRepositoriesRemoteDataSource(RepositoriesApiServiceFactory(session = session))

    private val gitHubAuthenticationRepository: GitHubAuthenticationRepository =
        GitHubAuthenticationRepositoryImpl(gitHubAuthenticationDataSource)
    private val gitHubRepositoriesRepository: GitHubRepositoriesRepository =
        GitHubRepositoriesRepositoryImpl(gitHubRepositoriesDataSource)

    val fetchGitHubUserTokenUseCase = FetchGitHubUserTokenUseCase(gitHubAuthenticationRepository)
    val fetchGitHubRepositoriesUseCase =
        FetchGitHubRepositoriesUseCase(gitHubRepositoriesRepository)

//    val fetchGitHubRepositoriesUseCaseFactory = FetchGitHubRepositoriesUseCaseFactory()

    val getSimpleAffirmationsUseCase =
        GetAffirmationsUseCase(AffirmationRepositoryImpl(SimpleAffirmationDataSource()))
    val getCustomAffirmationsUseCase =
        GetAffirmationsUseCase(AffirmationRepositoryImpl(CustomAffirmationDataSource()))
}
