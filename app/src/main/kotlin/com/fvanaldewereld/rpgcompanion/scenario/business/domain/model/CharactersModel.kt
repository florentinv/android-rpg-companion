package com.fvanaldewereld.rpgcompanion.scenario.business.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharactersModel(
    val characters: List<CharacterModel>? = null,
) : Parcelable, ScenarioElement
