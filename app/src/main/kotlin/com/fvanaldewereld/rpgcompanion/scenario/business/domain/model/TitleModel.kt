package com.fvanaldewereld.rpgcompanion.scenario.business.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TitleModel(
    val value: String? = "",
) : Parcelable, ScenarioElement
