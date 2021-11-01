package es.marcmauri.photobook.http.unsplash.entities

import com.google.gson.annotations.SerializedName

data class ApiPosition(
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double
)