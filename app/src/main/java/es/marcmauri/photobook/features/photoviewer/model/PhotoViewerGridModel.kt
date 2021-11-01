package es.marcmauri.photobook.features.photoviewer.model

import es.marcmauri.photobook.features.photoviewer.PhotoViewerGridMVP
import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashPhoto
import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashUser
import es.marcmauri.photobook.features.photoviewer.repository.UnsplashRepository
import java.text.SimpleDateFormat
import java.util.*

class PhotoViewerGridModel(val repository: UnsplashRepository) : PhotoViewerGridMVP.Model {

    override suspend fun getPhotosByPage(page: Int): List<UnsplashPhoto> {
        // todo: logica de negocio (pe: mapear objeto API con objeto Modelo
        return repository.getPhotosByPage(page).map { apiPhoto ->
            UnsplashPhoto(
                apiPhoto.id,
                stringToDate(apiPhoto.created_at),
                stringToDate(apiPhoto.updated_at),
                apiPhoto.alt_description,
                apiPhoto.urls.thumb,
                apiPhoto.urls.small,
                apiPhoto.urls.regular,
                UnsplashUser(
                    apiPhoto.user.id, apiPhoto.user.name, apiPhoto.user.instagram_username,
                    apiPhoto.user.profile_image.small
                ),
                null
            )
        }
    }

    /**
     * This method converts an API string with format "2020-07-01T18:31:27-04:00" to Date() object
     */
    fun stringToDate(sDate: String?) =
        sDate?.let {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.FRANCE).parse(sDate)
        } ?: Date()
}