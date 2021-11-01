package es.marcmauri.photobook.http.unsplash.entities.detailed

import com.google.gson.annotations.SerializedName

data class ApiDetailedAncestry(
    @SerializedName("type") val type: ApiDetailedType,
    @SerializedName("category") val category: ApiDetailedCategory,
    @SerializedName("subcategory") val subcategory: ApiDetailedSubcategory
)