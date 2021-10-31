package es.marcmauri.photobook.features.photoviewer.repository.impl

import es.marcmauri.photobook.features.photoviewer.repository.UnsplashRepository

class DummyUnsplashRepository : UnsplashRepository {
    override suspend fun getPhotosByPage(page: Int) {
        TODO("Not yet implemented")
    }
}