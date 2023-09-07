package com.fvanaldewereld.rpgcompanion.scenario.feature.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.GetScenarioByUrlUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.context.GlobalContext
import java.net.URL


private const val SCENARIO_UI_STATE_KEY = "SCENARIO_UI_STATE_KEY"

class ScenarioDetailViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val getScenarioByUrlUseCase: GetScenarioByUrlUseCase by GlobalContext.get().inject()

    private val googleDocsUrl = URL(
        "https://docs.google.com/document/d/1YMuTjXvyU_sZFOu8PlvX1DNlJ7t1h7ne4yQvDSWHE54/edit?usp=sharing",
    )

    var scenarioUiStateFlow: StateFlow<ScenarioUiState> =
        savedStateHandle.getStateFlow<ScenarioUiState>(
            SCENARIO_UI_STATE_KEY,
            ScenarioUiState.Loading,
        )

    init {
        if (scenarioUiStateFlow.value is ScenarioUiState.Loading) {
            getScenario()
        }
    }

    private fun getScenario() {
        CoroutineScope(Dispatchers.Default).launch {
            val scenario = getScenarioByUrlUseCase(googleDocsUrl)
            savedStateHandle[SCENARIO_UI_STATE_KEY] = ScenarioUiState.Success(value = scenario)
        }

    }

}