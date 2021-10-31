package es.marcmauri.photobook.features.photoviewer.view.listeners

import es.marcmauri.photobook.features.photoviewer.model.UnsplashPhoto

interface RecyclerPhotoGridListener {
    fun onPhotoItemClick(photo: UnsplashPhoto, position: Int)
    fun onPhotoItemLongClick(photo: UnsplashPhoto, position: Int)
    fun onPhotoItemLongClickReleased()
}