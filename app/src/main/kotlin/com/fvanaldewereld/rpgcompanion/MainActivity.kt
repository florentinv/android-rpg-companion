package com.fvanaldewereld.rpgcompanion


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.fvanaldewereld.rpgcompanion.scenario.business.di.SCENARIO_BUSINESS_MODULE
import com.fvanaldewereld.rpgcompanion.scenario.feature.di.SCENARIO_FEATURE_MODULE
import com.fvanaldewereld.rpgcompanion.scenario.feature.ui.ScenarioDetailActivity
import com.fvanaldewereld.rpgcompanion.ui.theme.RPGCompanionTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@MainActivity)
            modules(SCENARIO_BUSINESS_MODULE)
            modules(SCENARIO_FEATURE_MODULE)
        }

        setContent {
            MainContent()
        }
    }

    @Composable
    fun MainContent() {
        RPGCompanionTheme {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround,
                ) {
                    Button(onClick = ::goToScenarios) {
                        Text(stringResource(R.string.home_page_load_scenario_button_label))
                    }
                }
            }
        }
    }


    private fun goToScenarios() {
        startActivity(ScenarioDetailActivity.newInstance(this))
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MainContent()
    }

}


