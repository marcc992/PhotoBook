package es.marcmauri.photobook.http.unsplash.entities

import com.google.gson.annotations.SerializedName

data class ApiLinks(
    @SerializedName("self") val self: String,
    @SerializedName("html") val html: String,
    @SerializedName("photos") val photos: String,
    @SerializedName("likes") val likes: String,
    @SerializedName("portfolio") val portfolio: String,
    @SerializedName("following") val following: String,
    @SerializedName("followers") val followers: String
)