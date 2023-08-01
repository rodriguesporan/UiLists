package com.rodriguesporan.uilists.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class GitHubUserTokenDTO(
    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("expires_in")
    val expiresIn: Int,

    @SerializedName("refresh_token")
    val refreshToken: String,

    @SerializedName("refresh_token_expires_in")
    val refreshTokenExpiresIn: Int,

    @SerializedName("scope")
    val scope: String,

    @SerializedName("token_type")
    val tokenType: String
) : Parcelable
