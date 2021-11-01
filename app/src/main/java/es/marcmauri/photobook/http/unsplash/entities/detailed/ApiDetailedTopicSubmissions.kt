package es.marcmauri.photobook.http.unsplash.entities.detailed

import com.google.gson.annotations.SerializedName

data class ApiDetailedTopicSubmissions(
    @SerializedName("architecture") val architecture: ApiDetailedArchitecture
)