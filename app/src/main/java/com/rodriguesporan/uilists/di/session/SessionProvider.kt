package com.rodriguesporan.uilists.di.session

internal interface SessionProvider {
    fun isAuthorized(): Boolean
    fun getHeaderAuthorization(): String?
    fun saveAccessToken(accessToken: String)
}
