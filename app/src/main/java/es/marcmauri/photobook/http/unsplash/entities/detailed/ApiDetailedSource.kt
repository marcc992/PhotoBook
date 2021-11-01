package es.marcmauri.photobook.http.unsplash.entities.detailed

import com.google.gson.annotations.SerializedName

data class ApiDetailedSource(
    @SerializedName("ancestry") val ancestry: ApiDetailedAncestry,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("description") val description: String,
    @SerializedName("meta_title") val meta_title: String,
    @SerializedName("meta_description") val meta_description: String,
    @SerializedName("cover_photo") val cover_photo: ApiDetailedCoverPhoto
)