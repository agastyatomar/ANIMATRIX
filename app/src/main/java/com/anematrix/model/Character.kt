package com.anematrix.model

import android.os.Parcelable
import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val id: String = java.util.UUID.randomUUID().toString(),
    val name: String = "My Character",
    val animationFrames: Int = 0,
    val style: String = "stick",
    val createdAt: Long = System.currentTimeMillis(),
    var imageData: ByteArray? = null
) : Parcelable {
    override fun writeToParcel(dest: android.os.Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(name)
        dest.writeInt(animationFrames)
        dest.writeString(style)
        dest.writeLong(createdAt)
        dest.writeByteArray(imageData ?: emptyByteArray())
    }

    constructor(source: android.os.Parcel) : this(
        id = source.readString(),
        name = source.readString(),
        animationFrames = source.readInt(),
        style = source.readString(),
        createdAt = source.readLong(),
        imageData = source.createByteArray()
    )

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR = android.os.Parcelable.Creator<Character> { it }
    }
}