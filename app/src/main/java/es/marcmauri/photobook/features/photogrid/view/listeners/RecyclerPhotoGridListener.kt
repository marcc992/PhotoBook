package es.marcmauri.photobook.features.photogrid.view.listeners

interface RecyclerPhotoGridListener {
    fun onPhotoItemClick(photo: String, position: Int)
    fun onPhotoItemLongClick(photo: String, position: Int)
    fun onPhotoItemLongClickReleased()
}