package es.marcmauri.photobook.features.photoviewer.repository

import es.marcmauri.photobook.http.unsplash.entities.ApiPhoto

interface UnsplashRepository {

    suspend fun getPhotosByPage(page: Int): List<ApiPhoto>
}