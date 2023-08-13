package com.rodriguesporan.uilists.data

import android.net.Uri
import com.rodriguesporan.uilists.BuildConfig.GITHUB_CLIENT_ID_VALUE
import java.util.UUID

internal object GitHubUri {

    private val randomIdToProtectAgainstForgeryAttacks = UUID.randomUUID()

    fun String?.isComplianceWithSecurityStandards(): Boolean {
        return try {
            UUID.fromString(this) == randomIdToProtectAgainstForgeryAttacks
        } catch (e: Exception) {
            false
        }
    }

    fun buildGitHubUriApi(): Uri {
        return Uri.Builder()
            .scheme(GITHUB_SCHEME)
            .authority(GITHUB_AUTHORITY_API)
            .build()
    }

    fun buildGitHubUri(): Uri {
        return Uri.Builder()
            .scheme(GITHUB_SCHEME)
            .authority(GITHUB_AUTHORITY)
            .build()
    }

    fun buildGitHubUriAuthorize(): Uri {
        return Uri.Builder()
            .scheme(GITHUB_SCHEME)
            .authority(GITHUB_AUTHORITY)
            .appendPath("login")
            .appendPath("oauth")
            .appendPath("authorize")
            .appendQueryParameter(GITHUB_CLIENT_ID_KEY, GITHUB_CLIENT_ID_VALUE)
            .appendQueryParameter(GITHUB_REDIRECT_URI_KEY, GITHUB_REDIRECT_URI_VALUE)
            .appendQueryParameter(
                GITHUB_STATE_KEY,
                randomIdToProtectAgainstForgeryAttacks.toString()
            )
            .build()
    }

    const val GITHUB_REDIRECT_URI_VALUE = "uilists://login"

    private const val GITHUB_SCHEME = "https"
    private const val GITHUB_AUTHORITY = "github.com"
    private const val GITHUB_AUTHORITY_API = "api.github.com"
    private const val GITHUB_CLIENT_ID_KEY = "client_id"
    private const val GITHUB_REDIRECT_URI_KEY = "redirect_uri"
    private const val GITHUB_STATE_KEY = "state"
}