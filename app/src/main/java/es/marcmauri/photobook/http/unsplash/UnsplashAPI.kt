package es.marcmauri.photobook.http.unsplash

import es.marcmauri.photobook.http.unsplash.entities.ApiPhoto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UnsplashAPI {

    @GET("photos")
    suspend fun getPhotosByPage(@Query("page") page: Int): List<ApiPhoto>

    @GET("photos/{id}")
    suspend fun getPhotoDetails(@Path("id") photoId: String): ApiPhoto
}