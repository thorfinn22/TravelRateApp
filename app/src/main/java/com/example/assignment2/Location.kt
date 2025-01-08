package com.example.assignment2

import android.os.Parcelable
import android.os.Parcel

data class Location(
    val name: String,
    val region: String,
    val imageResourceId: Int,
    var rating: Float,
    val lastVisited: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readFloat(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(region)
        parcel.writeInt(imageResourceId)
        parcel.writeFloat(rating)
        parcel.writeString(lastVisited)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel): Location {
            return Location(parcel)
        }

        override fun newArray(size: Int): Array<Location?> {
            return arrayOfNulls(size)
        }
    }
}