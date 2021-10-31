package es.marcmauri.photobook.app

import android.app.Application
import es.marcmauri.photobook.features.photogrid.PhotoGridModule

class PhotoBookApp : Application() {
    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .photoGridModule(PhotoGridModule())
            .build()
    }

    fun getComponent() = component
}