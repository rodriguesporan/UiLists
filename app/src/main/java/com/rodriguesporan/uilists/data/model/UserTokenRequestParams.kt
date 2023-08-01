package com.rodriguesporan.uilists.data.model

import com.rodriguesporan.uilists.BuildConfig.GITHUB_CLIENT_ID_VALUE
import com.rodriguesporan.uilists.BuildConfig.GITHUB_CLIENT_SECRET_VALUE
import com.rodriguesporan.uilists.data.GitHubUri.GITHUB_REDIRECT_URI_VALUE

internal data class UserTokenRequestParams(
    val code: String,
    val clientId: String = GITHUB_CLIENT_ID_VALUE,
    val clientSecret: String = GITHUB_CLIENT_SECRET_VALUE,
    val redirectUri: String = GITHUB_REDIRECT_URI_VALUE,
    val repositoryId: String? = null
)
