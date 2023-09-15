package com.fvanaldewereld.rpgcompanion.scenario.business.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DescriptionModel(
    val paragraphs: List<String>? = emptyList(),
) : Parcelable