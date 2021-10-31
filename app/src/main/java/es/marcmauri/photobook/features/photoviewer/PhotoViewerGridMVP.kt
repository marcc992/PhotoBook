package es.marcmauri.photobook.features.photoviewer

import es.marcmauri.photobook.features.photoviewer.model.UnsplashPhoto

interface PhotoViewerGridMVP {

    interface View {
        fun configureUI()
        fun addPhotos(newPhotos: List<UnsplashPhoto>)
        fun openPhotoInfo(photo: UnsplashPhoto)
        fun showLoading()
        fun hideLoading()
        fun showError()
    }

    interface Presenter {
        fun setView(view: View)
        fun onFragmentReady()
        fun getPhotos(page: Int)
        fun onPhotoItemClick(photo: UnsplashPhoto)
    }
}