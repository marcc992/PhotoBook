package es.marcmauri.photobook.features.photogrid.view.listeners

import es.marcmauri.photobook.features.photogrid.model.UnsplashPhoto

interface RecyclerPhotoGridListener {
    fun onPhotoItemClick(photo: UnsplashPhoto, position: Int)
    fun onPhotoItemLongClick(photo: UnsplashPhoto, position: Int)
    fun onPhotoItemLongClickReleased()
}