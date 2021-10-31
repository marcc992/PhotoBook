package es.marcmauri.photobook.features.photoviewer.presenter

import android.util.Log
import androidx.annotation.Nullable
import es.marcmauri.photobook.features.photoviewer.PhotoViewerGridMVP
import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashPhoto
import kotlinx.coroutines.*

private const val TAG = "D_PhotoGridPresenter"

class PhotoGridPresenter(val model: PhotoViewerGridMVP.Model) : PhotoViewerGridMVP.Presenter {

    @Nullable
    private var view: PhotoViewerGridMVP.View? = null

    override fun setView(view: PhotoViewerGridMVP.View) {
        Log.d(TAG, "setView(view)")
        this.view = view
    }

    override fun onFragmentReady() {
        Log.d(TAG, "onFragmentReady(?)")
        view?.configureUI()
    }

    override fun getPhotos(page: Int) {
        Log.d(TAG, "getPhotos(page = $page?)")
        view?.showLoading()

        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                view?.showLoading()
            }

            delay(1000)
            val newPhotos = model.getPhotosByPage(page)

            withContext(Dispatchers.Main) {
                view?.let {  v ->
                    if (newPhotos.isNullOrEmpty()) {
                        v.showError("T: No se han encontrado (mas) fotos")
                    } else {
                        v.addPhotos(newPhotos)
                    }
                    v.hideLoading()
                }
            }

        }
    }

    override fun onPhotoItemClick(photo: UnsplashPhoto) {
        Log.d(TAG, "onPhotoItemClick(photo= ${photo.id})")
        view?.openPhotoInfo(photo)
    }
}