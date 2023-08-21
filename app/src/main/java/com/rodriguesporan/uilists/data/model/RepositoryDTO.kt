package com.rodriguesporan.uilists.data.model

import com.google.gson.annotations.SerializedName

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
    val description: String
)
