package com.fvanaldewereld.rpgcompanion.scenarioList.feature.ui.component

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fvanaldewereld.rpgcompanion.scenarioList.feature.ui.ScenarioListUiState
import com.fvanaldewereld.rpgcompanion.scenarioList.feature.ui.ScenarioListViewModel

@Composable
fun ScenarioListScreen(
    viewModel: ScenarioListViewModel,
    goToScenarioDetailPage: () -> Unit = {},
    onBackButtonPressed: () -> Unit = {},
) {
    when (val uiState = viewModel.scenarioListUiStateFlow.collectAsStateWithLifecycle().value) {
        is ScenarioListUiState.Loading ->
            ScenarioListLoading()

        is ScenarioListUiState.Success ->
            ScenarioListSuccess(
                scenarios = uiState.scenarios,
                onFabPressed = goToScenarioDetailPage,
                onBackButtonPressed = onBackButtonPressed,
            )
    }
}