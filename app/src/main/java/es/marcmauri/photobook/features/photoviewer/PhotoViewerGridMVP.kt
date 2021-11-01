package es.marcmauri.photobook.features.photoviewer

import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashPhoto

interface PhotoViewerGridMVP {

    interface View {
        fun configureUI()
        fun addPhotos(newPhotos: List<UnsplashPhoto>)
        fun openPhotoInfo(photo: UnsplashPhoto)
        fun showLoading()
        fun hideLoading()
        fun showNoMorePhotos()
        fun showError(message: String)
    }

    interface Presenter {
        fun setView(view: View)
        fun onFragmentReady()
        fun getPhotos(page: Int)
        fun onPhotoItemClick(photo: UnsplashPhoto)
    }

    interface Model {
        suspend fun getPhotosByPage(page: Int): List<UnsplashPhoto>?
    }
}