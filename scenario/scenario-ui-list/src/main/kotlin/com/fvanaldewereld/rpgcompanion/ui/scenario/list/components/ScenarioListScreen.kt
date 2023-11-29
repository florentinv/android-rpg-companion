package com.fvanaldewereld.rpgcompanion.ui.scenario.list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fvanaldewereld.rpgcompanion.common.ui.component.RpgCompanionTopAppBar
import com.fvanaldewereld.rpgcompanion.ui.scenario.list.R
import com.fvanaldewereld.rpgcompanion.ui.scenario.list.ScenarioListUiState
import com.fvanaldewereld.rpgcompanion.ui.scenario.list.ScenarioListViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScenarioListScreen(
    viewModel: ScenarioListViewModel,
    modifier: Modifier = Modifier,
    onBackButtonPressed: () -> Unit = {},
    onItemPressed: (id: Long) -> Unit = {},
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    Scaffold(
        modifier = modifier,
        topBar = {
            RpgCompanionTopAppBar(
                title = stringResource(R.string.scenarioList_topBar_title),
                onBackButtonPressed = onBackButtonPressed,
            )
        },
        floatingActionButton = {
            ScenarioListAddButton(onClick = { showBottomSheet = true })
        },
    ) {
        Box(modifier = Modifier.padding(it)) {
            when (val uiState = viewModel.scenarioListUiStateFlow.collectAsStateWithLifecycle().value) {
                is ScenarioListUiState.Error -> ScenarioListError(errorMessage = uiState.errorMessage)
                is ScenarioListUiState.Loading -> ScenarioListLoading()
                is ScenarioListUiState.NoResult -> ScenarioListNoResult()
                is ScenarioListUiState.Success -> ScenarioListSuccess(scenarios = uiState.scenarios, onItemPressed = onItemPressed)
            }
        }
    }
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
        ) {
            ScenarioListBottomSheet(
                onSubmitButtonPressed = {
                    scope
                        .launch { sheetState.hide() }
                        .invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet = false
                            }
                        }
                },
            )
        }
    }
}

