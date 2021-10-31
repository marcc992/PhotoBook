package es.marcmauri.photobook.features.photogrid

import dagger.Module
import dagger.Provides
import es.marcmauri.photobook.features.photogrid.presenter.PhotoGridPresenter

@Module
class PhotoGridModule {

    @Provides
    fun providePhotoGridPresenter(): PhotoGridMVP.Presenter = PhotoGridPresenter()
}