package com.anematrix.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.anematrix.model.Character

@Database(entities = [Character::class], version = 1, exportSchema = false)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao

    companion object {
        @Volatile
        private var INSTANCE: CharacterDatabase? = null

        fun getDatabase(context: Context): CharacterDatabase {
            return INSTANCE ?: synchronized(this) {
                val database = Room.databaseBuilder(
                    context.applicationContext,
                    CharacterDatabase::class.java,
                    "anematrix-db"
                ).build()
                INSTANCE = database
                database
            }
        }
    }
}