package com.fvanaldewereld.rpgcompanion.ui.scenario.list

import android.os.Parcelable
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.ScenarioModel
import kotlinx.parcelize.Parcelize

sealed interface ScenarioListUiState : Parcelable {
    @Parcelize
    object Loading : ScenarioListUiState

    @Parcelize
    data class Success(val scenarios: List<ScenarioModel>) : ScenarioListUiState
}
