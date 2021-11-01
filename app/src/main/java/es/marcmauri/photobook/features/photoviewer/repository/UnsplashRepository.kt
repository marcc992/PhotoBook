package es.marcmauri.photobook.features.photoviewer.repository

import es.marcmauri.photobook.http.unsplash.entities.ApiPhoto
import es.marcmauri.photobook.http.unsplash.entities.detailed.ApiDetailedPhoto

interface UnsplashRepository {

    suspend fun getPhotosByPage(page: Int): List<ApiPhoto>

    suspend fun getPhotoDetail(photoId: String): ApiDetailedPhoto
}