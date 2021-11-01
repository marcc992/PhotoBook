package es.marcmauri.photobook.http.unsplash.entities.detailed

import com.google.gson.annotations.SerializedName

data class ApiDetailedArchitecture(
    @SerializedName("status") val status: String,
    @SerializedName("approved_on") val approved_on: String
)