package es.marcmauri.photobook.features.photogrid.listeners

interface RecyclerPhotoGridListener {
    fun onPhotoItemClick(photo: String, position: Int)
}