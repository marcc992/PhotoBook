package es.marcmauri.photobook.features.photogrid

import es.marcmauri.photobook.features.photogrid.model.UnsplashPhoto

interface PhotoGridMVP {

    interface View {
        fun configureUI()
        fun addPhotos(newPhotos: List<UnsplashPhoto>)
        fun openPhotoInfo(photo: UnsplashPhoto)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun setView(view: View)
        fun onFragmentReady()
        fun getPhotos(page: Int)
        fun onPhotoItemClick(photo: UnsplashPhoto)
    }
}