package es.marcmauri.photobook.features.photoviewer.presenter

import android.util.Log
import androidx.annotation.Nullable
import es.marcmauri.photobook.features.photoviewer.PhotoViewerDetailMVP
import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashPhoto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG = "D_PhotoDetailPresenter"

class PhotoViewerDetailPresenter(val model: PhotoViewerDetailMVP.Model) :
    PhotoViewerDetailMVP.Presenter {

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
    }

    override fun getPhotoDetails(photoId: String) {
        Log.d(TAG, "getPhotoDetails(photoId = $photoId)")

        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                // Todo: loadings en los campos?
            }

            val camera = model.getCameraDetails(photoId)

            withContext(Dispatchers.Main) {
                view?.let { v ->
                    // Todo: remove loadings en los campos?
                    when (camera) {
                        null -> Log.e(TAG, "An error ocurrs while fetching camera details")
                        else -> {
                            v.setCameraMake("Modelo (mock): ${camera.make}")
                            v.setCameraModel("Marca (Mock): ${camera.model}")
                            v.setCameraModel("Name (Mock): ${camera.name}")
                        }
                    }
                }
            }
        }
    }

    override fun closeButtonClicked() {
        Log.d(TAG, "onCloseButtonClick()")
        view?.closeFragment()
    }
}