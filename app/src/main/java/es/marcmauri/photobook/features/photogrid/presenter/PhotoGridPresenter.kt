package es.marcmauri.photobook.features.photogrid.presenter

import android.util.Log
import androidx.annotation.Nullable
import es.marcmauri.photobook.features.photogrid.PhotoGridMVP
import kotlinx.coroutines.*

private const val TAG = "PhotoGridPresenter"

class PhotoGridPresenter : PhotoGridMVP.Presenter {

    @Nullable
    private var view: PhotoGridMVP.View? = null

    override fun setView(view: PhotoGridMVP.View) {
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

            val newPhotos = ArrayList<String>()
            newPhotos.add("https://images.vexels.com/media/users/3/213998/isolated/lists/4d0c121e997665d2715e1baffa3427e3-luna-simple-sistema-solar-luna.png")
            newPhotos.add("https://www.creativefabrica.com/wp-content/uploads/2020/04/25/illustration-of-natural-landscape-Graphics-3952025-1-1-580x412.jpg")
            newPhotos.add("https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/Campbell_Island_Landscape.jpg/800px-Campbell_Island_Landscape.jpg")
            newPhotos.add("https://img.freepik.com/free-vector/nature-scene-with-river-hills-forest-mountain-landscape-flat-cartoon-style-illustration_1150-37326.jpg?size=626&ext=jpg")
            newPhotos.add("https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/Campbell_Island_Landscape.jpg/640px-Campbell_Island_Landscape.jpg")
            newPhotos.add("https://www.canon.es/media/PCA%20Exercise%20-%20Landscape%20Photography%20exercise-landscape-photos-opener-05_1200%20x%20400_tcm86-1444470.jpg")
            newPhotos.add("https://cdn.mos.cms.futurecdn.net/33ey9QdnBu642B68fJE2Xf-1200-80.jpg")
            newPhotos.add("https://static.educalingo.com/img/en/800/landscape.jpg")
            newPhotos.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkeceC2cn2YxfKe8UEisZIucuAvrr4YS-Fbb7FSgK_VPzR-iL1ocj7dLE02pw9ETsmK7o&usqp=CAU")
            newPhotos.add("https://media.tacdn.com/media/attractions-splice-spp-674x446/06/88/c9/76.jpg")
            newPhotos.add("https://c8.alamy.com/compes/aw2kgn/camino-a-iruya-salta-provincia-de-salta-argentina-sudamerica-aw2kgn.jpg")
            newPhotos.add("https://i.ytimg.com/vi/PqPRU6und9c/maxresdefault.jpg")
            newPhotos.add("https://i.ytimg.com/vi/sAcO4sksBQ8/maxresdefault.jpg")
            newPhotos.add("https://i.pinimg.com/originals/23/d9/7a/23d97ab37dddae62bd952c2efae2e767.jpg")
            newPhotos.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRltLE7yvqEQE7vxWJDs-n4VeoCX_z0MnJfMV5rj1BgZDxySdjAUrhJiTk5UKsveQAW1Ik&usqp=CAU")
            newPhotos.add("https://www.fotopaises.com/Fotos-Paises/t/2007/3/23/3552_1174754322.jpg")

            withContext(Dispatchers.Main) {
                view?.addPhotos(newPhotos)
                view?.hideLoading()
            }

        }
    }

    override fun onPhotoItemClick(photo: String, position: Int) {
        Log.d(TAG, "onPhotoItemClick(position = $position)")
        view?.openPhotoInfo(photo)
    }
}