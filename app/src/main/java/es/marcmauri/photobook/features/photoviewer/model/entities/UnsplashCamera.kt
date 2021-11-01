package es.marcmauri.photobook.features.photoviewer.model.entities

import android.os.Parcel
import android.os.Parcelable

data class UnsplashCamera(
    val id: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<UnsplashCamera> {
        override fun createFromParcel(parcel: Parcel) = UnsplashCamera(parcel)
        override fun newArray(size: Int) = arrayOfNulls<UnsplashCamera?>(size)
    }
}