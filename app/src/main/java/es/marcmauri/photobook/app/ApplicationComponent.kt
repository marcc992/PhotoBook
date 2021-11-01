package es.marcmauri.photobook.app

import dagger.Component
import es.marcmauri.photobook.features.photoviewer.PhotoViewerModule
import es.marcmauri.photobook.features.photoviewer.view.activity.PhotoGridActivity
import es.marcmauri.photobook.features.photoviewer.view.fragment.PhotoDetailFragment
import es.marcmauri.photobook.features.photoviewer.view.fragment.PhotoGridFragment
import es.marcmauri.photobook.http.unsplash.UnsplashModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        PhotoViewerModule::class,
        UnsplashModule::class
    ]
)
interface ApplicationComponent {
    fun inject(photoGridActivity: PhotoGridActivity)
    fun inject(photoGridFragment: PhotoGridFragment)
    fun inject(photoDetailFragment: PhotoDetailFragment)
}