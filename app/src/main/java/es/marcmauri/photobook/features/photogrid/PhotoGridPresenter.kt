package es.marcmauri.photobook.features.photogrid

import android.os.Bundle
import android.util.Log
import androidx.annotation.Nullable

class PhotoGridPresenter : PhotoGridMVP.Presenter {
    private val TAG = "PhotoGridPresenter"

    @Nullable
    private var view: PhotoGridMVP.View? = null

    override fun setView(view: PhotoGridMVP.View) {
        Log.d(TAG, "setView(view)")
        this.view = view
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        Log.d(TAG, "onActivityReady(savedInstanceState?)")
        view?.configureUI()
    }

    override fun getPhotos(page: Int) {
        Log.d(TAG, "getPhotos(page = $page?)")
        val newPhotos = ArrayList<String>()
        newPhotos.add("Fotografia 1")
        newPhotos.add("Fotografia 2")
        newPhotos.add("Fotografia 3")
        newPhotos.add("Fotografia 4")
        newPhotos.add("Fotografia 5")
        newPhotos.add("Fotografia 6")
        newPhotos.add("Fotografia 7")
        newPhotos.add("Fotografia 8")
        newPhotos.add("Fotografia 9")
        newPhotos.add("Fotografia 10")
        newPhotos.add("Fotografia 11")
        newPhotos.add("Fotografia 12")
        newPhotos.add("Fotografia 13")
        newPhotos.add("Fotografia 14")
        newPhotos.add("Fotografia 15")
        newPhotos.add("Fotografia 16")

        view?.addPhotos(newPhotos)
    }

    override fun onPhotoItemClick(position: Int) {
        Log.d(TAG, "onPhotoItemClick(position = $position?)")
        TODO("Not yet implemented")
    }
}