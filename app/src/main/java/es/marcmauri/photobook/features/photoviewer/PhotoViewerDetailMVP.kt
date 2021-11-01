package es.marcmauri.photobook.features.photoviewer

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
        fun setAdditionalInfoFirst(text: String)
        fun setAdditionalInfoSecond(text: String)
        fun closeFragment()
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
    }

    interface Presenter {
        fun setView(view: View)
        fun onFragmentReady(photo: UnsplashPhoto)
        fun closeButtonClicked()
    }
}