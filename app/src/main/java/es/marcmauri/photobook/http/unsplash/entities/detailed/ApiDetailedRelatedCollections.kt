package es.marcmauri.photobook.http.unsplash.entities.detailed

import com.google.gson.annotations.SerializedName

data class ApiDetailedRelatedCollections(
    @SerializedName("total") val total: Int,
    @SerializedName("type") val type: String,
    @SerializedName("results") val results: List<ApiDetailedResults>
)