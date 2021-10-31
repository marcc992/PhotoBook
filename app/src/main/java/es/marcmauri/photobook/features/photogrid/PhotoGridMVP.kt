package es.marcmauri.photobook.features.photogrid

import android.os.Bundle

interface PhotoGridMVP {

    interface View {
        fun configureUI()
        fun addPhotos(newPhotos: List<String>)
        fun openPhotoInfo(photo: String)
        fun showLoading()
        fun hideLoading()
        fun showSnack(text: String)
    }

    interface Presenter {
        fun setView(view: View)
        fun onFragmentReady()
        fun getPhotos(page: Int)
        fun onPhotoItemClick(photo: String, position: Int)
    }
}