package com.fvanaldewereld.rpgcompanion.data.scenario.sources.localDatabase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.localDatabase.entities.Place

@Dao
interface PlaceDao {

    @Query("SELECT * FROM character WHERE scenarioId = :scenarioId")
    fun getAllByScenarioId(scenarioId: Long): List<Place>

    @Insert
    fun insert(place: Place)

    @Transaction
    fun insertAll(places: List<Place>) = places.forEach { insert(it) }

    @Delete
    fun delete(place: Place)

}