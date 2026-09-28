package com.anematrix.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Character(
    @PrimaryKey val id: String = java.util.UUID.randomUUID().toString(),
    val name: String = "My Character",
    val animationFrames: Int = 0,
    val style: String = "stick",
    val createdAt: Long = System.currentTimeMillis(),
    val imageData: ByteArray? = null
)
