package es.marcmauri.photobook.http.unsplash.entities.detailed

import com.google.gson.annotations.SerializedName

data class ApiDetailedTagsPreview(
    @SerializedName("type") val type: String,
    @SerializedName("title") val title: String
)