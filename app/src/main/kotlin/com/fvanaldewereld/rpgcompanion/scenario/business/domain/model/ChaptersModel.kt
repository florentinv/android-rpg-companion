package com.fvanaldewereld.rpgcompanion.scenario.business.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChaptersModel(
    val chapters: List<ChapterModel>? = emptyList(),
) : Parcelable, ScenarioElement
