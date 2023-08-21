package com.rodriguesporan.uilists.data.api

import com.rodriguesporan.uilists.data.model.UserTokenDTO
import retrofit2.http.POST
import retrofit2.http.QueryMap

internal interface AuthenticationApi {

    @POST(LOGIN_OAUTH_ACCESS_TOKEN_PATH)
    suspend fun fetchUserToken(
        @QueryMap requestQueryMap: Map<String, String>
    ): UserTokenDTO

    companion object {
        private const val LOGIN_OAUTH_ACCESS_TOKEN_PATH = "auth/token"
    }
}
