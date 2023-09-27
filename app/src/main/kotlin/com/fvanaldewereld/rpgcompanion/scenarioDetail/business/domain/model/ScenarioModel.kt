package com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScenarioModel(
    val author: AuthorModel? = null,
    val characters: CharactersModel? = null,
    val chapters: ChaptersModel? = null,
    val documentName: String? = "",
    val information: InformationModel? = InformationModel(),
    val places: PlacesModel? = null,
    val summary: SummaryModel? = null,
    val title: TitleModel? = null,
) : Parcelable
