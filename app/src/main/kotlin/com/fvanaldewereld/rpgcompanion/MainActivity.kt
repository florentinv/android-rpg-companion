package com.fvanaldewereld.rpgcompanion


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme
import com.fvanaldewereld.rpgcompanion.home.feature.di.HOME_FEATURE_MODULE
import com.fvanaldewereld.rpgcompanion.home.feature.ui.activity.HomeActivity.Companion.HOME_INTENT
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.di.SCENARIO_DETAIL_BUSINESS_MODULE
import com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.di.SCENARIO_DETAIL_FEATURE_MODULE
import com.fvanaldewereld.rpgcompanion.scenarioList.business.di.SCENARIO_LIST_BUSINESS_MODULE
import com.fvanaldewereld.rpgcompanion.scenarioList.feature.di.SCENARIO_LIST_FEATURE_MODULE
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@MainActivity)
            modules(HOME_FEATURE_MODULE)
            modules(SCENARIO_DETAIL_BUSINESS_MODULE)
            modules(SCENARIO_DETAIL_FEATURE_MODULE)
            modules(SCENARIO_LIST_BUSINESS_MODULE)
            modules(SCENARIO_LIST_FEATURE_MODULE)
        }

        setContent {
            RPGCompanionTheme {
                val navHostController = rememberNavController()
                MainNavigationGraph(
                    navHostController = navHostController,
                    goToHomePage = ::goToHomePage,
                )
            }
        }
    }

    private fun goToHomePage() {
        val homeIntent = get<Intent>(named(HOME_INTENT))
        startActivity(homeIntent)
    }

}