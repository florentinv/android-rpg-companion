package com.fvanaldewereld.rpgcompanion.ui.scenario.detail.di

import androidx.lifecycle.SavedStateHandle
import com.fvanaldewereld.rpgcompanion.ui.scenario.detail.ScenarioDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val SCENARIO_UI_DETAIL_MODULE = module {
    // ViewModels
    viewModel { (savedStateHandle: SavedStateHandle) -> ScenarioDetailViewModel(savedStateHandle) }
}
