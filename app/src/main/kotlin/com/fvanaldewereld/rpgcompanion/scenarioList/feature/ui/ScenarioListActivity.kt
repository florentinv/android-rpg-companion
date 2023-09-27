package com.fvanaldewereld.rpgcompanion.scenarioList.feature.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme
import com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.ui.ScenarioDetailActivity.Companion.SCENARIO_DETAIL_INTENT
import com.fvanaldewereld.rpgcompanion.scenarioList.feature.ui.component.ScenarioListLoading
import com.fvanaldewereld.rpgcompanion.scenarioList.feature.ui.component.ScenarioListSuccess
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named


class ScenarioListActivity : ComponentActivity() {

    private val viewModel: ScenarioListViewModel by viewModel<ScenarioListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RPGCompanionTheme {
                when (val scenarioUiState = viewModel.scenarioListUiStateFlow.collectAsStateWithLifecycle().value) {
                    is ScenarioListUiState.Loading ->
                        ScenarioListLoading()

                    is ScenarioListUiState.Success ->
                        ScenarioListSuccess(
                            scenarios = scenarioUiState.scenarios,
                            onFabPressed = ::goToScenarioDetailPage,
                        )
                }
            }
        }
    }

    private fun goToScenarioDetailPage() {
        val scenarioDetailIntent = get<Intent>(named(SCENARIO_DETAIL_INTENT))
        startActivity(scenarioDetailIntent)
    }

    companion object {
        const val SCENARIO_LIST_INTENT = "SCENARIO_LIST_INTENT"
        fun intent(
            context: Context,
        ) = Intent(context, ScenarioListActivity::class.java)
    }

}