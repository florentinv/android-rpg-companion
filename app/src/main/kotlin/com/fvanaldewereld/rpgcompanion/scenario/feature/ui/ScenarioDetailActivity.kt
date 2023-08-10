package com.fvanaldewereld.rpgcompanion.scenario.feature.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fvanaldewereld.rpgcompanion.scenario.feature.ui.component.ScenarioDetailLoading
import com.fvanaldewereld.rpgcompanion.scenario.feature.ui.component.ScenarioDetailSuccess
import org.koin.androidx.viewmodel.ext.android.viewModel


class ScenarioDetailActivity : ComponentActivity() {

    private val viewModel: ScenarioDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            when (val scenarioUiState =
                viewModel.scenarioUiStateFlow.collectAsStateWithLifecycle().value) {
                is ScenarioUiState.Loading ->
                    ScenarioDetailLoading()

                is ScenarioUiState.Success ->
                    ScenarioDetailSuccess(
                        scenarioUI = scenarioUiState.value,
                    )
            }
        }
    }

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, ScenarioDetailActivity::class.java)
        }
    }

}