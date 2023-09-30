package com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SummaryModel(
    val text: DescriptionModel? = null,
) : Parcelable, ScenarioElement
