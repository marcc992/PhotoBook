package es.marcmauri.photobook.features.photogrid.presenter

import android.util.Log
import androidx.annotation.Nullable
import es.marcmauri.photobook.features.photogrid.PhotoDetailMVP

private const val TAG = "D_PhotoDetailPresenter"

class PhotoDetailPresenter : PhotoDetailMVP.Presenter {

    @Nullable
    private var view: PhotoDetailMVP.View? = null


    override fun setView(view: PhotoDetailMVP.View) {
        Log.d(TAG, "setView(view)")
        this.view = view
    }

    override fun onFragmentReady(photo: String) {
        Log.d(TAG, "onFragmentReady(photo = $photo)")
        view?.configureUI()
        view?.setImage(photo)
        view?.setTitle(photo)
        view?.setAuthor(photo)
        view?.setAdditionalInfoFirst(photo)
        view?.setAdditionalInfoSecond(photo)
    }

    override fun onCloseButtonClick() {
        Log.d(TAG, "onCloseButtonClick()")
        view?.closeFragment()
    }
}