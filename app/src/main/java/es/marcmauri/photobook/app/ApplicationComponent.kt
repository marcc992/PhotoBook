package es.marcmauri.photobook.app

import dagger.Component
import es.marcmauri.photobook.features.photogrid.PhotoGridActivity
import es.marcmauri.photobook.features.photogrid.PhotoGridModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        PhotoGridModule::class
    ]
)
interface ApplicationComponent {
    fun inject(photoGridActivity: PhotoGridActivity)
}