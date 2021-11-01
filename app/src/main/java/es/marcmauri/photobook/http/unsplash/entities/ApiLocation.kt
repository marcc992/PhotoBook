package es.marcmauri.photobook.http.unsplash.entities

import com.google.gson.annotations.SerializedName

data class ApiLocation(
    @SerializedName("city") val city: String,
    @SerializedName("country") val country: String,
    @SerializedName("position") val position: ApiPosition
)