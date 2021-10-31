package es.marcmauri.photobook.features.photoviewer.model.entities

import android.os.Parcel
import android.os.Parcelable

data class UnsplashUser(
    val id: String,
    val name: String,
    val instagram: String?,
    val profileImageUrl: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(instagram)
        parcel.writeString(profileImageUrl)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<UnsplashUser> {
        override fun createFromParcel(parcel: Parcel) = UnsplashUser(parcel)
        override fun newArray(size: Int) = arrayOfNulls<UnsplashUser?>(size)
    }
}