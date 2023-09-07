package com.fvanaldewereld.rpgcompanion.scenario.feature.ui

import android.os.Parcelable
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.ScenarioModel
import kotlinx.parcelize.Parcelize

sealed interface ScenarioUiState : Parcelable {
    @Parcelize
    object Loading : ScenarioUiState

    @Parcelize
    data class Success(val value: ScenarioModel) : ScenarioUiState

}