package es.marcmauri.photobook.http.unsplash.entities.detailed

import com.google.gson.annotations.SerializedName

data class ApiDetailedResults(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("published_at") val published_at: String,
    @SerializedName("last_collected_at") val last_collected_at: String,
    @SerializedName("updated_at") val updated_at: String,
    @SerializedName("curated") val curated: Boolean,
    @SerializedName("featured") val featured: Boolean,
    @SerializedName("total_photos") val total_photos: Int,
    @SerializedName("private") val private: Boolean,
    @SerializedName("share_key") val share_share_key: String,
    @SerializedName("tags") val tags: List<ApiDetailedTags>,
    @SerializedName("links") val links: ApiDetailedLinks,
    @SerializedName("user") val user: ApiDetailedUser,
    @SerializedName("cover_photo") val cover_photo: ApiDetailedCoverPhoto,
    @SerializedName("preview_photos") val preview_photos: List<ApiDetailedPreviewPhotos>
)