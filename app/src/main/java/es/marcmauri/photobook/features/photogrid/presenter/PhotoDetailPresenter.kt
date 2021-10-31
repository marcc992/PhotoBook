package es.marcmauri.photobook.features.photogrid.presenter

import android.util.Log
import androidx.annotation.Nullable
import es.marcmauri.photobook.features.photogrid.PhotoDetailMVP
import es.marcmauri.photobook.features.photogrid.model.UnsplashPhoto

private const val TAG = "D_PhotoDetailPresenter"

class PhotoDetailPresenter : PhotoDetailMVP.Presenter {

    @Nullable
    private var view: PhotoDetailMVP.View? = null


    override fun setView(view: PhotoDetailMVP.View) {
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

    override fun onCloseButtonClick() {
        Log.d(TAG, "onCloseButtonClick()")
        view?.closeFragment()
    }
}