package com.fvanaldewereld.rpgcompanion.scenarioList.feature.di

import androidx.lifecycle.SavedStateHandle
import com.fvanaldewereld.rpgcompanion.scenarioList.feature.ui.ScenarioListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val SCENARIO_LIST_FEATURE_MODULE = module {
    // Mappers

    // ViewModels
    viewModel { (savedStateHandle: SavedStateHandle) -> ScenarioListViewModel(savedStateHandle) }
}
