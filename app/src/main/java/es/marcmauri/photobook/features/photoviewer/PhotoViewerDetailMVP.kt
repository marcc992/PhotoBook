package es.marcmauri.photobook.features.photoviewer

import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashCamera
import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashPhoto
import java.util.*

interface PhotoViewerDetailMVP {

    interface View {
        fun configureUI()
        fun setImage(url: String)
        fun setAuthorImage(url: String?)
        fun setAuthorName(name: String)
        fun setAuthorInstagram(instagram: String?)
        fun setPhotoDate(date: Date)
        fun setCameraMake(make: String)
        fun setCameraModel(model: String)
        fun setCameraName(name: String)
        fun closeFragment()
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
    }

    interface Presenter {
        fun setView(view: View)
        fun onFragmentReady(photo: UnsplashPhoto)
        fun getPhotoDetails(photoId: String)
        fun closeButtonClicked()
    }

    interface Model {
        suspend fun getCameraDetails(photoId: String): UnsplashCamera?
    }
}