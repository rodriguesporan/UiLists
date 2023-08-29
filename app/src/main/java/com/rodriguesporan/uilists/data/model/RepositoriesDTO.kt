package com.rodriguesporan.uilists.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class RepositoriesDTO(
    @SerializedName("data")
    val collection: List<RepositoryDTO>
): Parcelable
