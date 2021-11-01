package es.marcmauri.photobook.http.unsplash.entities.detailed

import com.google.gson.annotations.SerializedName

data class ApiDetailedTags(
    @SerializedName("type") val type: String,
    @SerializedName("title") val title: String,
    @SerializedName("source") val source: ApiDetailedSource
)