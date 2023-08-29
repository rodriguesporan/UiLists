package com.rodriguesporan.uilists.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class RepositoryDTO(
    @SerializedName("id")
    val id: Int,

    @SerializedName("node_id")
    val nodeId: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("owner")
    val owner: RepositoryOwnerDTO,

    @SerializedName("html_url")
    val htmlUrl: String,

    @SerializedName("description")
    val description: String?
): Parcelable
