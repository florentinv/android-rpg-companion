package com.fvanaldewereld.rpgcompanion.api.domain.scenario.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DescriptionModel(
    val paragraphs: List<String>? = emptyList(),
) : Parcelable, Model
