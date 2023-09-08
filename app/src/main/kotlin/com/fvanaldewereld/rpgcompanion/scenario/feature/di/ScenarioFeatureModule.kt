package com.fvanaldewereld.rpgcompanion.scenario.feature.di

import androidx.lifecycle.SavedStateHandle
import com.fvanaldewereld.rpgcompanion.scenario.feature.ui.ScenarioDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val SCENARIO_FEATURE_MODULE = module {
    // Mappers

    // ViewModels
    viewModel { (savedStateHandle: SavedStateHandle) -> ScenarioDetailViewModel(savedStateHandle) }
}
