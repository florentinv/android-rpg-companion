package com.fvanaldewereld.rpgcompanion.scenario.feature.ui

import android.os.Parcelable
import com.fvanaldewereld.rpgcompanion.scenario.feature.model.ScenarioUi
import kotlinx.parcelize.Parcelize

sealed interface ScenarioUiState : Parcelable {
    @Parcelize
    object Loading : ScenarioUiState

    @Parcelize
    data class Success(val value: ScenarioUi) : ScenarioUiState

}