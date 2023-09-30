package com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.di

import androidx.lifecycle.SavedStateHandle
import com.fvanaldewereld.rpgcompanion.scenarioDetail.feature.ui.ScenarioDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val SCENARIO_DETAIL_FEATURE_MODULE = module {
    // Mappers

    // ViewModels
    viewModel { (savedStateHandle: SavedStateHandle) -> ScenarioDetailViewModel(savedStateHandle) }
}
