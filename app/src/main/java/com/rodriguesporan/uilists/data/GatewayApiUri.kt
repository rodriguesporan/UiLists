package com.rodriguesporan.uilists.data

import android.net.Uri
import com.rodriguesporan.uilists.BuildConfig.GATEWAY_API_HOST
import com.rodriguesporan.uilists.BuildConfig.GATEWAY_API_PORT
import com.rodriguesporan.uilists.BuildConfig.GATEWAY_API_SCHEME

internal object GatewayApiUri {

    fun buildGatewayApiUri(vararg paths: String): Uri {
        val builder: Uri.Builder = Uri.Builder()
            .scheme(GATEWAY_API_SCHEME)
            .encodedAuthority("${GATEWAY_API_HOST}:${GATEWAY_API_PORT}")
        paths.forEach { path ->
            builder.appendPath(path)
        }
        return builder.build()
    }

    const val DEEPLINK_GITHUB_REDIRECT_URI_VALUE = "uilists://login"
    const val GATEWAY_API_PATH_AUTHORIZE = "authorize"
}
