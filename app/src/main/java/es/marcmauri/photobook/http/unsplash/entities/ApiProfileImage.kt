package es.marcmauri.photobook.http.unsplash.entities

import com.google.gson.annotations.SerializedName

data class ApiProfileImage(
    @SerializedName("small") val small: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("large") val large: String
)