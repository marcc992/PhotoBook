package es.marcmauri.photobook.features.photogrid

import android.os.Bundle

interface PhotoDetailMVP {

    interface View {
        fun setImage(url: String)
        fun setTitle(title: String)
        fun setAuthor(author: String)
        fun setDate(date: String)
        fun setAdditionalInfoFirst(text: String)
        fun setAdditionalInfoSecond(text: String)
        fun closeFragment()
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun setView(view: View)
        fun onFragmentReady(photo: String)
        fun onCloseButtonClick()
    }
}