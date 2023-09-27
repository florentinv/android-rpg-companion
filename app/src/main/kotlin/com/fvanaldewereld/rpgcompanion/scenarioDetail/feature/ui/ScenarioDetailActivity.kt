package com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme
import com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.ui.component.ScenarioDetailLoading
import com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.ui.component.ScenarioDetailSuccess
import org.koin.androidx.viewmodel.ext.android.viewModel


class ScenarioDetailActivity : ComponentActivity() {

    private val viewModel: ScenarioDetailViewModel by viewModel<ScenarioDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RPGCompanionTheme {
                when (val state = viewModel.scenarioDetailUiStateFlow.collectAsStateWithLifecycle().value) {
                    is ScenarioDetailUiState.Loading ->
                        ScenarioDetailLoading()

                    is ScenarioDetailUiState.Success ->
                        ScenarioDetailSuccess(
                            scenario = state.scenario,
                        )
                }
            }
        }
    }

    companion object {
        const val SCENARIO_DETAIL_INTENT = "SCENARIO_DETAIL_INTENT"
        fun intent(
            context: Context,
        ) = Intent(context, ScenarioDetailActivity::class.java)
    }

}