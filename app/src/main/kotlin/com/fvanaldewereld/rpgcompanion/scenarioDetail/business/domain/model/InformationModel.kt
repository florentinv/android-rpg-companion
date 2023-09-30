package com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InformationModel(
    val genres: List<String>? = emptyList(),
    val nbPlayers: Int? = 1,
    val themes: List<String>? = emptyList(),
) : Parcelable, ScenarioElement
