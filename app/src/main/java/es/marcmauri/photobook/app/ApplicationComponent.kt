package es.marcmauri.photobook.app

import dagger.Component
import es.marcmauri.photobook.features.photoviewer.PhotoViewerModule
import es.marcmauri.photobook.features.photoviewer.view.activity.PhotoGridActivity
import es.marcmauri.photobook.features.photoviewer.view.fragment.PhotoViewerDetailFragment
import es.marcmauri.photobook.features.photoviewer.view.fragment.PhotoViewerGridFragment
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
    fun inject(photoViewerGridFragment: PhotoViewerGridFragment)
    fun inject(photoViewerDetailFragment: PhotoViewerDetailFragment)
}