package com.fvanaldewereld.rpgcompanion.home.feature.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme
import com.fvanaldewereld.rpgcompanion.home.feature.ui.component.HomeScreen
import com.fvanaldewereld.rpgcompanion.scenarioList.feature.ui.ScenarioListActivity.Companion.SCENARIO_LIST_INTENT
import org.koin.android.ext.android.get
import org.koin.core.qualifier.named

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContent {
            RPGCompanionTheme {
                HomeScreen(
                    onAccessButtonPressed = ::goToScenarioListPage,
                )
            }
        }
    }

    private fun goToScenarioListPage() {
        val scenarioListIntent = get<Intent>(named(SCENARIO_LIST_INTENT))
        startActivity(scenarioListIntent)
    }

    companion object {

        const val HOME_INTENT = "HOME_INTENT"
        fun intent(
            context: Context,
        ) = Intent(context, HomeActivity::class.java)
    }
}