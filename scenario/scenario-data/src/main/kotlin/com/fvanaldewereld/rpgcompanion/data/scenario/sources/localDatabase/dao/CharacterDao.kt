package com.fvanaldewereld.rpgcompanion.data.scenario.sources.localDatabase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.localDatabase.entities.Character

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character WHERE scenarioId = :scenarioId")
    fun getAllByScenarioId(scenarioId: Long): List<Character>

    @Insert
    fun insert(character: Character)

    @Transaction
    fun insertAll(characters: List<Character>) = characters.forEach { insert(it) }

    @Delete
    fun delete(character: Character)
}