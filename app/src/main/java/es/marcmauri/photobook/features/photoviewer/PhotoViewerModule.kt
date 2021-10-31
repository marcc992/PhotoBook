package es.marcmauri.photobook.features.photoviewer

import dagger.Module
import dagger.Provides
import es.marcmauri.photobook.features.photoviewer.model.PhotoViewerGridModel
import es.marcmauri.photobook.features.photoviewer.presenter.PhotoViewerDetailPresenter
import es.marcmauri.photobook.features.photoviewer.presenter.PhotoViewerGridPresenter
import es.marcmauri.photobook.features.photoviewer.repository.UnsplashRepository
import es.marcmauri.photobook.features.photoviewer.repository.impl.DummyUnsplashRepository

@Module
class PhotoViewerModule {

    @Provides
    fun providePhotoViewerGridPresenter(model: PhotoViewerGridMVP.Model): PhotoViewerGridMVP.Presenter =
        PhotoViewerGridPresenter(model)

    @Provides
    fun providePhotoViewerGridModel(repository: UnsplashRepository): PhotoViewerGridMVP.Model =
        PhotoViewerGridModel(repository)

    @Provides
    fun provideUnsplashRepository(): UnsplashRepository = DummyUnsplashRepository()

    @Provides
    fun providePhotoViewerDetailPresenter(): PhotoViewerDetailMVP.Presenter = PhotoViewerDetailPresenter()
}