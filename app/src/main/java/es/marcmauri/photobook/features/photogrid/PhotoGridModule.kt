package es.marcmauri.photobook.features.photogrid

import dagger.Module
import dagger.Provides

@Module
class PhotoGridModule {

    @Provides
    fun providePhotoGridPresenter(): PhotoGridMVP.Presenter = PhotoGridPresenter()
}