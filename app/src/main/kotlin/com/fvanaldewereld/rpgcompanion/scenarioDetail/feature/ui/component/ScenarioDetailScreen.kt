package com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.ui.component

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.ui.ScenarioDetailUiState
import com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.ui.ScenarioDetailViewModel

@Composable
fun ScenarioDetailScreen(
    viewModel: ScenarioDetailViewModel,
    onBackButtonPressed: () -> Unit = {},
) {
    when (val state = viewModel.scenarioDetailUiStateFlow.collectAsStateWithLifecycle().value) {
        is ScenarioDetailUiState.Loading ->
            ScenarioDetailLoading()

        is ScenarioDetailUiState.Success ->
            ScenarioDetailSuccess(
                scenario = state.scenario,
                onBackButtonPressed = onBackButtonPressed,
            )
    }
}