package com.fvanaldewereld.rpgcompanion.scenario.feature.model

import android.os.Parcelable
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.TreeModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScenarioUi(
    val documentName: String? = "",
    val tree: TreeModel? = null,
) : Parcelable