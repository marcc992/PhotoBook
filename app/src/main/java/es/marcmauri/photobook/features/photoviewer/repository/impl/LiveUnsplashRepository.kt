package es.marcmauri.photobook.features.photoviewer.repository.impl

import es.marcmauri.photobook.features.photoviewer.repository.UnsplashRepository
import es.marcmauri.photobook.http.unsplash.UnsplashAPI

class LiveUnsplashRepository(val unsplashApi: UnsplashAPI) : UnsplashRepository {

    // Todo: controlar errores
    override suspend fun getPhotosByPage(page: Int) = unsplashApi.getPhotosByPage(page)

}