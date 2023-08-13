package com.rodriguesporan.uilists.di

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rodriguesporan.uilists.data.GitHubUri.buildGitHubUri
import com.rodriguesporan.uilists.data.GitHubUri.buildGitHubUriApi
import com.rodriguesporan.uilists.data.api.AuthenticationApi
import com.rodriguesporan.uilists.data.api.RepositoriesApi
import com.rodriguesporan.uilists.data.datasource.CustomAffirmationDataSource
import com.rodriguesporan.uilists.data.datasource.GitHubAuthenticationRemoteDataSource
import com.rodriguesporan.uilists.data.datasource.GitHubRepositoriesRemoteDataSource
import com.rodriguesporan.uilists.data.datasource.SimpleAffirmationDataSource
import com.rodriguesporan.uilists.data.repository.AffirmationRepositoryImpl
import com.rodriguesporan.uilists.data.repository.GitHubAuthenticationRepositoryImpl
import com.rodriguesporan.uilists.data.repository.GitHubRepositoriesRepositoryImpl
import com.rodriguesporan.uilists.di.session.SessionProvider
import com.rodriguesporan.uilists.di.session.SessionProviderImpl
import com.rodriguesporan.uilists.domain.repository.GitHubAuthenticationRepository
import com.rodriguesporan.uilists.domain.repository.GitHubRepositoriesRepository
import com.rodriguesporan.uilists.domain.usecase.FetchGitHubRepositoriesUseCase
import com.rodriguesporan.uilists.domain.usecase.FetchGitHubUserTokenUseCase
import com.rodriguesporan.uilists.domain.usecase.GetAffirmationsUseCase
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class AppContainer(
    context: Context
) {
    private val gson: Gson = GsonBuilder().setLenient().create()
    private val gitHubAuthenticationDataSource =
        GitHubAuthenticationRemoteDataSource(
            buildRetrofit(RetrofitGitHubHost.BASE).create(
                AuthenticationApi::class.java
            )
        )

    private val gitHubRepositoriesDataSource = GitHubRepositoriesRemoteDataSource(
        buildRetrofit(RetrofitGitHubHost.API).create(RepositoriesApi::class.java)
    )
    private val gitHubAuthenticationRepository: GitHubAuthenticationRepository =
        GitHubAuthenticationRepositoryImpl(gitHubAuthenticationDataSource)
    private val gitHubRepositoriesRepository: GitHubRepositoriesRepository =
        GitHubRepositoriesRepositoryImpl(gitHubRepositoriesDataSource)
    val fetchGitHubUserTokenUseCase = FetchGitHubUserTokenUseCase(gitHubAuthenticationRepository)
    val fetchGitHubRepositoriesUseCase =
        FetchGitHubRepositoriesUseCase(gitHubRepositoriesRepository)
    val getSimpleAffirmationsUseCase =
        GetAffirmationsUseCase(AffirmationRepositoryImpl(SimpleAffirmationDataSource()))
    val getCustomAffirmationsUseCase =
        GetAffirmationsUseCase(AffirmationRepositoryImpl(CustomAffirmationDataSource()))
    val session: SessionProvider = SessionProviderImpl(context)

    private fun buildRetrofit(type: RetrofitGitHubHost): Retrofit {
        val baseUrl = when (type) {
            RetrofitGitHubHost.API -> buildGitHubUriApi().toString()
            RetrofitGitHubHost.BASE -> buildGitHubUri().toString()
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val headerAuthorizationValue = session.getHeaderAuthorization()
                val request = if (headerAuthorizationValue != null && type == RetrofitGitHubHost.API) {
                    val requestBuilder = chain.request().newBuilder()
                    requestBuilder.header("Authorization", headerAuthorizationValue)
                    requestBuilder.build()
                } else {
                    chain.request()
                }
                Log.i(
                    "RETROFITREQUEST",
                    "Sending request ${request.url} on ${chain.connection()}\n${request.headers}"
                )
                return@addInterceptor chain.proceed(request).also { response ->
                    Log.i(
                        "RETROFITRESPONSE",
                        "Received response for ${response.request.url}\n${response.headers}\n${response}"
                    )
                }
            }
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient.build())
            .build()
    }

    private enum class RetrofitGitHubHost {
        API,
        BASE
    }
}
