package com.fvanaldewereld.rpgcompanion.ui.scenario.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fvanaldewereld.rpgcompanion.lib.domain.scenario.usecases.GetScenarioByUrlUseCase
import java.net.URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.context.GlobalContext

class ScenarioDetailViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    companion object {
        const val SCENARIO_UI_STATE_KEY = "SCENARIO_UI_STATE_KEY"
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
            savedStateHandle[SCENARIO_UI_STATE_KEY] =
                ScenarioDetailUiState.Success(scenario = scenario)
        }
    }
}