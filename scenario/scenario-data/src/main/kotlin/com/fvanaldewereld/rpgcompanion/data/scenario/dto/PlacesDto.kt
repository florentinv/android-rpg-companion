package com.fvanaldewereld.rpgcompanion.data.scenario.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlacesDto(
    val places: List<PlaceEntity>? = emptyList(),
) : Parcelable, ScenarioElementDto
