package com.fvanaldewereld.rpgcompanion.api.domain.scenario.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SummaryModel(
    val text: DescriptionModel? = null,
) : Parcelable, ScenarioElementModel
