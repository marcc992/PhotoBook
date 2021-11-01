package es.marcmauri.photobook.features.photoviewer

import dagger.Module
import dagger.Provides
import es.marcmauri.photobook.features.photoviewer.model.PhotoViewerDetailModel
import es.marcmauri.photobook.features.photoviewer.model.PhotoViewerGridModel
import es.marcmauri.photobook.features.photoviewer.presenter.PhotoViewerDetailPresenter
import es.marcmauri.photobook.features.photoviewer.presenter.PhotoViewerGridPresenter
import es.marcmauri.photobook.features.photoviewer.repository.UnsplashRepository
import es.marcmauri.photobook.features.photoviewer.repository.impl.LiveUnsplashRepository
import es.marcmauri.photobook.http.unsplash.UnsplashAPI
import javax.inject.Singleton

@Module
class PhotoViewerModule {

    @Provides
    fun providePhotoViewerGridPresenter(model: PhotoViewerGridMVP.Model): PhotoViewerGridMVP.Presenter =
        PhotoViewerGridPresenter(model)

    @Provides
    fun providePhotoViewerGridModel(repository: UnsplashRepository): PhotoViewerGridMVP.Model =
        PhotoViewerGridModel(repository)

    @Provides
    fun providePhotoViewerDetailPresenter(model: PhotoViewerDetailMVP.Model): PhotoViewerDetailMVP.Presenter =
        PhotoViewerDetailPresenter(model)

    @Provides
    fun providePhotoViewerDetailModel(repository: UnsplashRepository): PhotoViewerDetailMVP.Model =
        PhotoViewerDetailModel(repository)

    @Singleton
    @Provides
    fun provideUnsplashRepository(unsplashApi: UnsplashAPI): UnsplashRepository =
        LiveUnsplashRepository(unsplashApi)
}