package es.marcmauri.photobook.features.photoviewer.presenter

import android.util.Log
import androidx.annotation.Nullable
import es.marcmauri.photobook.features.photoviewer.PhotoViewerDetailMVP
import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashPhoto

private const val TAG = "D_PhotoDetailPresenter"

class PhotoViewerDetailPresenter : PhotoViewerDetailMVP.Presenter {

    @Nullable
    private var view: PhotoViewerDetailMVP.View? = null


    override fun setView(view: PhotoViewerDetailMVP.View) {
        Log.d(TAG, "setView(view)")
        this.view = view
    }

    override fun onFragmentReady(photo: UnsplashPhoto) {
        Log.d(TAG, "onFragmentReady(photo = $photo)")
        view?.configureUI()
        view?.setImage(photo.regularUrl)
        view?.setAuthorImage(photo.user.profileImageUrl)
        view?.setAuthorName(photo.user.name)
        view?.setAuthorInstagram(photo.user.instagram)
        view?.setPhotoDate(photo.createdAt)
        view?.setAdditionalInfoFirst("Some info from Camera(?)")
        view?.setAdditionalInfoSecond("Some more info from Camera(?)")
    }

    override fun closeButtonClicked() {
        Log.d(TAG, "onCloseButtonClick()")
        view?.closeFragment()
    }
}