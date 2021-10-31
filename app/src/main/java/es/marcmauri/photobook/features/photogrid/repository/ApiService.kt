package es.marcmauri.photobook.features.photogrid.repository

import es.marcmauri.photobook.features.photogrid.model.UnsplashPhoto
import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun getPhotosByPage(): List<UnsplashPhoto>
}