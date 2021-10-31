package es.marcmauri.photobook.features.photoviewer

import es.marcmauri.photobook.features.photoviewer.model.UnsplashPhoto

interface PhotoViewerDetailMVP {

    interface View {
        fun configureUI()
        fun setImage(url: String)
        fun setTitle(title: String)
        fun setAuthor(author: String)
        fun setDate(date: String)
        fun setAdditionalInfoFirst(text: String)
        fun setAdditionalInfoSecond(text: String)
        fun closeFragment()
        fun showLoading()
        fun hideLoading()
        fun showError()
    }

    interface Presenter {
        fun setView(view: View)
        fun onFragmentReady(photo: UnsplashPhoto)
        fun onCloseButtonClick()
    }
}