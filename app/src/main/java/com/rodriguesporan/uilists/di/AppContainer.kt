package com.rodriguesporan.uilists.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rodriguesporan.uilists.data.GitHubUri.buildBaseUri
import com.rodriguesporan.uilists.data.api.AuthenticationApi
import com.rodriguesporan.uilists.data.datasource.GitHubAuthenticationRemoteDataSource
import com.rodriguesporan.uilists.data.datasource.CustomAffirmationDataSource
import com.rodriguesporan.uilists.data.datasource.SimpleAffirmationDataSource
import com.rodriguesporan.uilists.data.repository.AffirmationRepositoryImpl
import com.rodriguesporan.uilists.data.repository.GitHubAuthenticationRepositoryImpl
import com.rodriguesporan.uilists.di.session.SessionProvider
import com.rodriguesporan.uilists.di.session.SessionProviderImpl
import com.rodriguesporan.uilists.domain.repository.GitHubAuthenticationRepository
import com.rodriguesporan.uilists.domain.usecase.FetchGitHubUserTokenUseCase
import com.rodriguesporan.uilists.domain.usecase.GetAffirmationsUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class AppContainer(
    context: Context
) {
    private val gson: Gson = GsonBuilder().setLenient().create()
    private val retrofit = Retrofit.Builder()
        .baseUrl(buildBaseUri().toString())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    private val gitHubAuthenticationRemoteDataSource =
        GitHubAuthenticationRemoteDataSource(retrofit.create(AuthenticationApi::class.java))
    private val gitHubAuthenticationRepository: GitHubAuthenticationRepository =
        GitHubAuthenticationRepositoryImpl(gitHubAuthenticationRemoteDataSource)
    val fetchGitHubUserTokenUseCase = FetchGitHubUserTokenUseCase(gitHubAuthenticationRepository)
    val getSimpleAffirmationsUseCase =
        GetAffirmationsUseCase(AffirmationRepositoryImpl(SimpleAffirmationDataSource()))
    val getCustomAffirmationsUseCase =
        GetAffirmationsUseCase(AffirmationRepositoryImpl(CustomAffirmationDataSource()))
    val session: SessionProvider = SessionProviderImpl(context)
}
