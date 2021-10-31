package es.marcmauri.photobook.app

import dagger.Component
import es.marcmauri.photobook.features.photoviewer.PhotoViewerModule
import es.marcmauri.photobook.features.photoviewer.view.activity.PhotoGridActivity
import es.marcmauri.photobook.features.photoviewer.view.fragment.PhotoDetailFragment
import es.marcmauri.photobook.features.photoviewer.view.fragment.PhotoGridFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        PhotoViewerModule::class
    ]
)
interface ApplicationComponent {
    fun inject(photoGridActivity: PhotoGridActivity)
    fun inject(photoGridFragment: PhotoGridFragment)
    fun inject(photoDetailFragment: PhotoDetailFragment)
}