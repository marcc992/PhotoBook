package es.marcmauri.photobook.http.unsplash.entities.detailed

import com.google.gson.annotations.SerializedName

data class ApiDetailedPosition(
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double
)