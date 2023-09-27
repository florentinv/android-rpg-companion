package com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlaceModel(
    val name: String? = "",
    val description: DescriptionModel? = null,
) : Parcelable
