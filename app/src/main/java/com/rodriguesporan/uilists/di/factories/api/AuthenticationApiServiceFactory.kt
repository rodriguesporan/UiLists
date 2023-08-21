package com.rodriguesporan.uilists.di.factories.api

import com.rodriguesporan.uilists.data.api.AuthenticationApi
import com.rodriguesporan.uilists.di.session.SessionProvider

internal class AuthenticationApiServiceFactory(val session: SessionProvider) :
    ApiServiceFactory<AuthenticationApi>(AuthenticationApi::class.java, session)
