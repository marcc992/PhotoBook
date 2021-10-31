package es.marcmauri.photobook.features.photoviewer.model.entities

import es.marcmauri.photobook.features.photoviewer.PhotoViewerGridMVP
import es.marcmauri.photobook.features.photoviewer.repository.UnsplashRepository

class PhotoViewerGridModel(val repository: UnsplashRepository) : PhotoViewerGridMVP.Model {

    override suspend fun getPhotosByPage(page: Int): List<UnsplashPhoto> {
        // todo: logica de negocio (pe: mapear objeto API con objeto Modelo
        return repository.getPhotosByPage(page)
    }
}