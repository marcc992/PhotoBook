package es.marcmauri.photobook.features.photoviewer.view.listeners

import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashPhoto

interface RecyclerPhotoGridListener {
    fun onPhotoItemClick(photo: UnsplashPhoto, position: Int)
    fun onPhotoItemLongClick(photo: UnsplashPhoto, position: Int)
    fun onPhotoItemLongClickReleased()
}