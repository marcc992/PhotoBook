package es.marcmauri.photobook.http.unsplash.entities.detailed

import com.google.gson.annotations.SerializedName

data class ApiDetailedLocation(
    @SerializedName("title") val title: String,
    @SerializedName("name") val name: String,
    @SerializedName("city") val city: String,
    @SerializedName("country") val country: String,
    @SerializedName("position") val position: ApiDetailedPosition
)