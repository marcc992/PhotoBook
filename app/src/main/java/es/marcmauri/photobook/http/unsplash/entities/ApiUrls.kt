package es.marcmauri.photobook.http.unsplash.entities

import com.google.gson.annotations.SerializedName

data class ApiUrls(
    @SerializedName("raw") val raw: String,
    @SerializedName("full") val full: String,
    @SerializedName("regular") val regular: String,
    @SerializedName("small") val small: String,
    @SerializedName("thumb") val thumb: String
)