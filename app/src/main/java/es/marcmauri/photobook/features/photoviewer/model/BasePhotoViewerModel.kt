package es.marcmauri.photobook.features.photoviewer.model

import java.text.SimpleDateFormat
import java.util.*

abstract class BasePhotoViewerModel() {

    /**
     * This method converts an API string with format "2020-07-01T18:31:27-04:00" to Date() object
     */
    fun stringToDate(sDate: String?) =
        sDate?.let {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.FRANCE).parse(sDate)
        } ?: Date()
}