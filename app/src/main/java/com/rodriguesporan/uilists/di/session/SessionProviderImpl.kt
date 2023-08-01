package com.rodriguesporan.uilists.di.session

import android.app.Application.MODE_PRIVATE
import android.content.Context
import android.content.SharedPreferences

internal class SessionProviderImpl(
    context: Context
) : SessionProvider {
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(PREFERENCE_FILE_KEY, MODE_PRIVATE)

    override fun isAuthorized(): Boolean {
        return getAccessToken()?.isNotBlank() == true
    }

    override fun getHeaderAuthorization(): String? {
        return getAccessToken()?.let { "Bearer $it" }
    }

    override fun saveAccessToken(accessToken: String) {
        sharedPref.edit().let { editor ->
            editor.putString(SAVED_ACCESS_TOKEN_KEY, accessToken)
            editor.apply()
        }
    }

    private fun getAccessToken(): String? {
        return sharedPref.getString(SAVED_ACCESS_TOKEN_KEY, null)
    }

    companion object {
        private const val PREFERENCE_FILE_KEY = "com.rodriguesporan.uilists.PREFERENCE_FILE_KEY"
        private const val SAVED_ACCESS_TOKEN_KEY = "saved_access_token_key"
    }
}
