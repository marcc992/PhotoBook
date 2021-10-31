package es.marcmauri.photobook.features.photoviewer.repository

import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashPhoto

interface UnsplashRepository {

    suspend fun getPhotosByPage(page: Int): List<UnsplashPhoto>
}