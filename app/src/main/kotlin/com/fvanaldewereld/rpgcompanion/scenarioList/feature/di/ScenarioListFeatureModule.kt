package com.fvanaldewereld.rpgcompanion.scenarioList.feature.di

import android.content.Intent
import com.fvanaldewereld.rpgcompanion.scenarioList.feature.ui.ScenarioListActivity
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val SCENARIO_LIST_FEATURE_MODULE = module {
    // Mappers

    // ViewModels

    // Intent
    factory<Intent>(named(ScenarioListActivity.SCENARIO_LIST_INTENT)) { ScenarioListActivity.intent(androidContext()) }
}
