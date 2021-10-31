package es.marcmauri.photobook.features.photogrid

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.annotation.Nullable
import kotlinx.coroutines.*

class PhotoGridPresenter : PhotoGridMVP.Presenter {
    private val TAG = "PhotoGridPresenter"

    @Nullable
    private var view: PhotoGridMVP.View? = null
    @Nullable
    private var context: Context? = null

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
        view?.showLoading()

        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                view?.showLoading()
            }
            delay(1000)

            val newPhotos = ArrayList<String>()
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")

            withContext(Dispatchers.Main) {
                view?.addPhotos(newPhotos)
                view?.hideLoading()
            }

        }
    }

    override fun onPhotoItemClick(position: Int) {
        Log.d(TAG, "onPhotoItemClick(position = $position?)")
        TODO("Not yet implemented")
    }
}