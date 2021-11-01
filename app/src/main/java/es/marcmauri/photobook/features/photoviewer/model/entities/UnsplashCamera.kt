package es.marcmauri.photobook.features.photoviewer.model.entities

import android.os.Parcel
import android.os.Parcelable

data class UnsplashCamera(
    val make: String?,
    val model: String?,
    val name: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(make)
        parcel.writeString(model)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UnsplashCamera> {
        override fun createFromParcel(parcel: Parcel): UnsplashCamera {
            return UnsplashCamera(parcel)
        }

        override fun newArray(size: Int): Array<UnsplashCamera?> {
            return arrayOfNulls(size)
        }
    }

}