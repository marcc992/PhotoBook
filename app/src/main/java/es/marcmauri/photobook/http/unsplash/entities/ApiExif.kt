package es.marcmauri.photobook.http.unsplash.entities

import com.google.gson.annotations.SerializedName

data class ApiExif(
    @SerializedName("make") val make: String,
    @SerializedName("model") val model: String,
    @SerializedName("name") val name: String,
    @SerializedName("exposure_time") val exposureTime: Double,
    @SerializedName("aperture") val aperture: Double,
    @SerializedName("focal_length") val focalLength: Int,
    @SerializedName("iso") val iso: Int
)