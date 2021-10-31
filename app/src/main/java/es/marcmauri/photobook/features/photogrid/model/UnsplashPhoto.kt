package es.marcmauri.photobook.features.photogrid.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class UnsplashPhoto(
    val id: String,
    val createdAt: Date,
    val updatedAt: Date,
    val description: String?,
    val thumbUrl: String,
    val smallUrl: String,
    val regularUrl: String,
    val user: UnsplashUser,
    val camera: UnsplashCamera?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        Date(parcel.readLong()),
        Date(parcel.readLong()),
        parcel.readString(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readParcelable(UnsplashUser::class.java.classLoader)!!,
        parcel.readParcelable(UnsplashCamera::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(description)
        parcel.writeLong(createdAt.time)
        parcel.writeLong(updatedAt.time)
        parcel.writeString(thumbUrl)
        parcel.writeString(smallUrl)
        parcel.writeString(regularUrl)
        parcel.writeParcelable(user, flags)
        parcel.writeParcelable(camera, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UnsplashPhoto> {
        override fun createFromParcel(parcel: Parcel): UnsplashPhoto {
            return UnsplashPhoto(parcel)
        }

        override fun newArray(size: Int): Array<UnsplashPhoto?> {
            return arrayOfNulls(size)
        }
    }
}