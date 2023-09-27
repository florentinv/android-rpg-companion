package com.fvanaldewereld.rpgcompanion.scenarioList.feature.ui

import android.os.Parcelable
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain.model.ScenarioModel
import kotlinx.parcelize.Parcelize

sealed interface ScenarioListUiState : Parcelable {
    @Parcelize
    object Loading : ScenarioListUiState

    @Parcelize
    data class Success(val scenarios: List<ScenarioModel>) : ScenarioListUiState

}