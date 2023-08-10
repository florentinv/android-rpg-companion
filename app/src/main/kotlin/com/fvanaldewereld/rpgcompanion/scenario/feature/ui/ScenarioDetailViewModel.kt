package com.fvanaldewereld.rpgcompanion.scenario.feature.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.GetScenarioByUrlUseCase
import com.fvanaldewereld.rpgcompanion.scenario.feature.mapper.ScenarioUiMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.context.GlobalContext
import java.net.URL


private const val SCENARIO_UI_STATE_KEY = "DOC_TITLE_KEY"

class ScenarioDetailViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val getScenarioByUrlUseCase: GetScenarioByUrlUseCase by GlobalContext.get().inject()
    private val scenarioUiMapper: ScenarioUiMapper by GlobalContext.get().inject()

    private val googleDocsUrl = URL(
        "https://docs.google.com/document/d/1EAJa9JbA9tbGNbyv5AHIherdT34C4Ks6hKyIyDlZ7Os/edit?usp=sharing",
    )

    var scenarioUiStateFlow =
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
        CoroutineScope(Dispatchers.Default).launch() {
            val scenarioModel = getScenarioByUrlUseCase(googleDocsUrl)
            val scenarioUI = scenarioUiMapper.to(scenarioModel)
            savedStateHandle[SCENARIO_UI_STATE_KEY] = ScenarioUiState.Success(value = scenarioUI)
        }
    }

}