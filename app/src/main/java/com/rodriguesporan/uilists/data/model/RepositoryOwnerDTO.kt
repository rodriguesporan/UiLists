package com.rodriguesporan.uilists.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class RepositoryOwnerDTO(
    @SerializedName("login")
    val login: String
) : Parcelable
