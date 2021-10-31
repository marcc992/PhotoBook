package es.marcmauri.photobook.features.photoviewer

import dagger.Module
import dagger.Provides
import es.marcmauri.photobook.features.photoviewer.model.PhotoViewerGridModel
import es.marcmauri.photobook.features.photoviewer.presenter.PhotoDetailPresenter
import es.marcmauri.photobook.features.photoviewer.presenter.PhotoGridPresenter
import es.marcmauri.photobook.features.photoviewer.repository.UnsplashRepository
import es.marcmauri.photobook.features.photoviewer.repository.impl.DummyUnsplashRepository

@Module
class PhotoViewerModule {

    @Provides
    fun providePhotoViewerGridPresenter(model: PhotoViewerGridMVP.Model): PhotoViewerGridMVP.Presenter =
        PhotoGridPresenter(model)

    @Provides
    fun providePhotoViewerGridModel(repository: UnsplashRepository): PhotoViewerGridMVP.Model =
        PhotoViewerGridModel(repository)

    @Provides
    fun provideUnsplashRepository(): UnsplashRepository = DummyUnsplashRepository()

    @Provides
    fun providePhotoViewerDetailPresenter(): PhotoViewerDetailMVP.Presenter = PhotoDetailPresenter()
}