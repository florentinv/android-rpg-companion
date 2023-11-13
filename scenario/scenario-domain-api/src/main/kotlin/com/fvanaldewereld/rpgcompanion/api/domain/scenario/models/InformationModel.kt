package com.fvanaldewereld.rpgcompanion.api.domain.scenario.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InformationModel(
    val genres: List<String>? = emptyList(),
    val nbPlayers: Int? = 1,
    val themes: List<String>? = emptyList(),
) : Parcelable, ScenarioElementModel
