package es.marcmauri.photobook.features.photoviewer.repository

interface UnsplashRepository {

    suspend fun getPhotosByPage(page: Int)
}