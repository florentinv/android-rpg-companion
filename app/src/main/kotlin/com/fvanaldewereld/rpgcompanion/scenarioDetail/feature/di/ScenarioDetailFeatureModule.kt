package com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.di

import android.content.Intent
import androidx.lifecycle.SavedStateHandle
import com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.ui.ScenarioDetailActivity
import com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.ui.ScenarioDetailViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val SCENARIO_DETAIL_FEATURE_MODULE = module {
    // Mappers

    // ViewModels
    viewModel { (savedStateHandle: SavedStateHandle) -> ScenarioDetailViewModel(savedStateHandle) }

    // Intent
    factory<Intent>(named(ScenarioDetailActivity.SCENARIO_DETAIL_INTENT)) { ScenarioDetailActivity.intent(androidContext()) }
}
