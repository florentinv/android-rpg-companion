package com.fvanaldewereld.rpgcompanion.ui.scenario.list.components

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fvanaldewereld.rpgcompanion.ui.scenario.list.ScenarioListUiState
import com.fvanaldewereld.rpgcompanion.ui.scenario.list.ScenarioListViewModel

@Composable
fun ScenarioListScreen(
    viewModel: ScenarioListViewModel,
    onGoToScenarioDetailButtonPressed: () -> Unit = {},
    onBackButtonPressed: () -> Unit = {},
) {
    when (val uiState = viewModel.scenarioListUiStateFlow.collectAsStateWithLifecycle().value) {
        is ScenarioListUiState.Loading ->
            ScenarioListLoading()

        is ScenarioListUiState.Success ->
            ScenarioListSuccess(
                scenarios = uiState.scenarios,
                onFabPressed = onGoToScenarioDetailButtonPressed,
                onBackButtonPressed = onBackButtonPressed,
            )
    }
}
