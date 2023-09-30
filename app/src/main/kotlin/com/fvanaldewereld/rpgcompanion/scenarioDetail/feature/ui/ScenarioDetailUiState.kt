package com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.ui

import android.os.Parcelable
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain.model.ScenarioModel
import kotlinx.parcelize.Parcelize

sealed interface ScenarioDetailUiState : Parcelable {
    @Parcelize
    object Loading : ScenarioDetailUiState

    @Parcelize
    data class Success(val scenario: ScenarioModel) : ScenarioDetailUiState

}