package com.rodriguesporan.uilists.di.factories.api

import com.rodriguesporan.uilists.data.api.RepositoriesApi
import com.rodriguesporan.uilists.di.session.SessionProvider

internal class RepositoriesApiServiceFactory(val session: SessionProvider) :
    ApiServiceFactory<RepositoriesApi>(RepositoriesApi::class.java, session)
