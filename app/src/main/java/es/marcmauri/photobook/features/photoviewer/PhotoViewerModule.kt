package es.marcmauri.photobook.features.photoviewer

import dagger.Module
import dagger.Provides
import es.marcmauri.photobook.features.photoviewer.presenter.PhotoDetailPresenter
import es.marcmauri.photobook.features.photoviewer.presenter.PhotoGridPresenter

@Module
class PhotoViewerModule {

    @Provides
    fun providePhotoGridPresenter(): PhotoViewerGridMVP.Presenter = PhotoGridPresenter()

    @Provides
    fun providePhotoDetailPresenter(): PhotoViewerDetailMVP.Presenter = PhotoDetailPresenter()
}