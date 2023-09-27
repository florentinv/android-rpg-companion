package com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain.GetScenarioByUrlUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.context.GlobalContext
import java.net.URL


class ScenarioDetailViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    companion object {
        private const val SCENARIO_UI_STATE_KEY = "SCENARIO_UI_STATE_KEY"
    }

    private val getScenarioByUrlUseCase: GetScenarioByUrlUseCase by GlobalContext.get().inject()

    private val googleDocsUrl = URL(
        "https://docs.google.com/document/d/1YMuTjXvyU_sZFOu8PlvX1DNlJ7t1h7ne4yQvDSWHE54/edit?usp=sharing",
    )

    var scenarioDetailUiStateFlow: StateFlow<ScenarioDetailUiState> =
        savedStateHandle.getStateFlow<ScenarioDetailUiState>(
            SCENARIO_UI_STATE_KEY,
            ScenarioDetailUiState.Loading,
        )

    init {
        if (scenarioDetailUiStateFlow.value is ScenarioDetailUiState.Loading) {
            getScenario()
        }
    }

    private fun getScenario() {
        CoroutineScope(Dispatchers.Default).launch {
            val scenario = getScenarioByUrlUseCase(googleDocsUrl)
            savedStateHandle[SCENARIO_UI_STATE_KEY] = ScenarioDetailUiState.Success(scenario = scenario)
        }

    }

}