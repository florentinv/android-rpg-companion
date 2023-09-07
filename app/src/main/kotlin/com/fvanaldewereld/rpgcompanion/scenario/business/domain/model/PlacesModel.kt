package com.fvanaldewereld.rpgcompanion.scenario.business.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlacesModel(
    val places: List<PlaceModel>? = emptyList(),
) : Parcelable, ScenarioElement
