package es.marcmauri.photobook.http.unsplash.entities.detailed

import com.google.gson.annotations.SerializedName

data class ApiDetailedExif(
    @SerializedName("make") val make: String,
    @SerializedName("model") val model: String,
    @SerializedName("name") val name: String,
    @SerializedName("exposure_time") val exposure_time: String,
    @SerializedName("aperture") val aperture: Double,
    @SerializedName("focal_length") val focal_length: Double,
    @SerializedName("iso") val iso: Int
)