package es.marcmauri.photobook.app

import android.app.Application
import es.marcmauri.photobook.features.photoviewer.PhotoViewerModule
import es.marcmauri.photobook.http.unsplash.UnsplashModule

class PhotoBookApp : Application() {
    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .photoViewerModule(PhotoViewerModule())
            .unsplashModule(UnsplashModule())
            .build()
    }

    fun getComponent() = component
}