package es.marcmauri.photobook.http.unsplash.entities

import com.google.gson.annotations.SerializedName

data class ApiPhoto(
    @SerializedName("id") val id: String,
    @SerializedName("created_at") val created_at: String,
    @SerializedName("updated_at") val updated_at: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("color") val color: String,
    @SerializedName("blur_hash") val blur_hash: String,
    @SerializedName("description") val description: String,
    @SerializedName("alt_description") val alt_description: String,
    @SerializedName("exif") val exif : ApiExif,
    @SerializedName("location") val location : ApiLocation,
    @SerializedName("tags") val tags : List<ApiTag>,
    @SerializedName("urls") val urls: ApiUrls,
    @SerializedName("links") val links: ApiLinks,
    @SerializedName("likes") val likes: Int,
    @SerializedName("user") val user: ApiUser
)