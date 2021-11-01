package es.marcmauri.photobook.http.unsplash.entities.detailed

import com.google.gson.annotations.SerializedName

data class ApiDetailedSubcategory(
    @SerializedName("slug") val slug: String,
    @SerializedName("pretty_slug") val pretty_slug: String
)