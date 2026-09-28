package com.anematrix.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anematrix.model.Character
import java.util.List

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCharacter(character: Character)

    @Query("SELECT * FROM character ORDER BY createdAt DESC")
    suspend fun getAllCharacters(): List<Character>

    @Query("DELETE FROM character")
    suspend fun clearAllCharacters()

    @Query("SELECT * FROM character WHERE id = :id")
    suspend fun getCharacterById(id: String): Character?
}