package es.marcmauri.photobook.app

import android.app.Application
import es.marcmauri.photobook.features.photoviewer.PhotoViewerModule

class PhotoBookApp : Application() {
    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .photoViewerModule(PhotoViewerModule())
            .build()
    }

    fun getComponent() = component
}