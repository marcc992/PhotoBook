package es.marcmauri.photobook.http.unsplash.entities.detailed

import com.google.gson.annotations.SerializedName

data class ApiDetailedMeta(
    @SerializedName("index") val index: Boolean
)