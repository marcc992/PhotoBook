package es.marcmauri.photobook.features.photoviewer.presenter

import android.util.Log
import androidx.annotation.Nullable
import es.marcmauri.photobook.features.photoviewer.PhotoViewerDetailMVP
import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashPhoto

private const val TAG = "D_PhotoDetailPresenter"

class PhotoDetailPresenter : PhotoViewerDetailMVP.Presenter {

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
        photo.description?.let { view?.setTitle(it) }
        view?.setAuthor(photo.user.name)
        view?.setAdditionalInfoFirst("@${photo.user.instagram}")
        view?.setAdditionalInfoSecond("Profile image: ${photo.user.profileImageUrl}")
    }

    override fun closeButtonClicked() {
        Log.d(TAG, "onCloseButtonClick()")
        view?.closeFragment()
    }
}