package com.fvanaldewereld.rpgcompanion.ui.scenario.list

import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fvanaldewereld.rpgcompanion.common.dispatchers.KDispatchers
import com.fvanaldewereld.rpgcompanion.lib.domain.scenario.usecases.AddScenarioUseCase
import com.fvanaldewereld.rpgcompanion.lib.domain.scenario.usecases.GetScenarioListUseCase
import com.fvanaldewereld.rpgcompanion.mockFactory.ScenarioModelMockFactory
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.context.GlobalContext

class ScenarioListViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    companion object {
        const val SCENARIO_LIST_UI_STATE_KEY = "SCENARIO_LIST_UI_STATE_KEY"
    }

    private val addScenarioUseCase: AddScenarioUseCase by GlobalContext.get().inject()
    private val getScenarioListUseCase: GetScenarioListUseCase by GlobalContext.get().inject()
    private val dispatchers: KDispatchers by GlobalContext.get().inject()

    var scenarioListUiStateFlow: StateFlow<ScenarioListUiState> =
        savedStateHandle.getStateFlow<ScenarioListUiState>(
            SCENARIO_LIST_UI_STATE_KEY,
            ScenarioListUiState.Loading,
        )

    init {
        if (scenarioListUiStateFlow.value is ScenarioListUiState.Loading) {
            addMockedScenario()
        }
    }

    // TODO Remove after setting up the adding with FAB
    private fun addMockedScenario() {
        viewModelScope.launch {
            withContext(dispatchers.default()) {
                // TODO Search or implement a handler for SQLiteException (maybe in Usecase or Repository)
                kotlin.runCatching { addScenarioUseCase.invoke(ScenarioModelMockFactory.scenarioModel) }
                    .onFailure { throwable ->
                        if (throwable is SQLiteConstraintException) Log.e("DATABASE ERROR", "${throwable.localizedMessage}")
                    }
                getScenarioList()
            }
        }
    }

    private fun getScenarioList() {
        viewModelScope.launch {
            withContext(dispatchers.default()) {
                // TODO Catch SQLiteException
                kotlin.runCatching { getScenarioListUseCase() }
                    .onSuccess { scenarios -> savedStateHandle[SCENARIO_LIST_UI_STATE_KEY] = ScenarioListUiState.Success(scenarios = scenarios) }
            }
        }
    }
}