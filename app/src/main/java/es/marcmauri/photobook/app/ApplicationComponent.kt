package es.marcmauri.photobook.app

import dagger.Component
import es.marcmauri.photobook.features.photogrid.PhotoGridModule
import es.marcmauri.photobook.features.photogrid.view.activity.PhotoGridActivity
import es.marcmauri.photobook.features.photogrid.view.fragment.PhotoDetailFragment
import es.marcmauri.photobook.features.photogrid.view.fragment.PhotoGridFragment
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
    fun inject(photoGridFragment: PhotoGridFragment)
    fun inject(photoDetailFragment: PhotoDetailFragment)
}