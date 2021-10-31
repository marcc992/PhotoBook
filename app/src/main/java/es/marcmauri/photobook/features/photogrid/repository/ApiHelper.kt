package es.marcmauri.photobook.features.photogrid.repository

class ApiHelper(private val apiService: ApiService) {

    suspend fun getPhotosByPage() = apiService.getPhotosByPage()
}