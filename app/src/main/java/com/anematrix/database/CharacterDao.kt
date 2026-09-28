package com.anematrix.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anematrix.model.Character

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: Character)

    @Query("SELECT * FROM characters ORDER BY createdAt DESC")
    suspend fun getAllCharacters(): List<Character>

    @Query("DELETE FROM characters")
    suspend fun clearAllCharacters()

    @Query("SELECT * FROM characters WHERE id = :id LIMIT 1")
    suspend fun getCharacterById(id: String): Character?
}
