package es.marcmauri.photobook.features.photoviewer.model

import android.util.Log
import es.marcmauri.photobook.features.photoviewer.PhotoViewerDetailMVP
import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashCamera
import es.marcmauri.photobook.features.photoviewer.repository.UnsplashRepository

private const val TAG = "D_PhotoViewerGridModel"

class PhotoViewerDetailModel(val repository: UnsplashRepository) : PhotoViewerDetailMVP.Model,
    BasePhotoViewerModel() {

    override suspend fun getCameraDetails(photoId: String): UnsplashCamera? {
        return try {
            repository.getPhotoDetail(photoId).exif.let { camera ->
                UnsplashCamera(
                    camera.make,
                    camera.model,
                    camera.name
                )
            }
        } catch (e: Exception) {
            Log.e(TAG, "Something was wrong calling Unsplash API /GET Photos/{id=$photoId} -> $e")
            null
        }
    }
}