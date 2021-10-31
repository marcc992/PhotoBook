package es.marcmauri.photobook.features.photogrid.repository

class UnsplashRepository(private val apiHelper: ApiHelper) {

    suspend fun getPhotosByPage() = apiHelper.getPhotosByPage()
}