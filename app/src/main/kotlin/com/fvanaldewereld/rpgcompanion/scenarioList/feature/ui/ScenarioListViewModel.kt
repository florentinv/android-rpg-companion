package com.fvanaldewereld.rpgcompanion.scenarioList.feature.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fvanaldewereld.rpgcompanion.scenarioList.business.domain.GetScenarioListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.context.GlobalContext


class ScenarioListViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    companion object {
        private const val SCENARIO_LIST_UI_STATE_KEY = "SCENARIO_LIST_UI_STATE_KEY"
    }

    private val getScenarioListUseCase: GetScenarioListUseCase by GlobalContext.get().inject()

    var scenarioListUiStateFlow: StateFlow<ScenarioListUiState> =
        savedStateHandle.getStateFlow<ScenarioListUiState>(
            SCENARIO_LIST_UI_STATE_KEY,
            ScenarioListUiState.Loading,
        )

    init {
        if (scenarioListUiStateFlow.value is ScenarioListUiState.Loading) {
            getScenarioList()
        }
    }

    private fun getScenarioList() {
        CoroutineScope(Dispatchers.Default).launch {
            val scenarios = getScenarioListUseCase()
            savedStateHandle[SCENARIO_LIST_UI_STATE_KEY] = ScenarioListUiState.Success(scenarios = scenarios)
        }

    }

}