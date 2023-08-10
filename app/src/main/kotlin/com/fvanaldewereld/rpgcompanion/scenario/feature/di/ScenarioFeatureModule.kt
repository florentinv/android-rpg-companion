package com.fvanaldewereld.rpgcompanion.scenario.feature.di

import androidx.lifecycle.SavedStateHandle
import com.fvanaldewereld.rpgcompanion.scenario.feature.mapper.ScenarioUiMapper
import com.fvanaldewereld.rpgcompanion.scenario.feature.mapper.ScenarioUiMapperImpl
import com.fvanaldewereld.rpgcompanion.scenario.feature.ui.ScenarioDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val SCENARIO_FEATURE_MODULE = module {
    // Mappers
    single<ScenarioUiMapper> { ScenarioUiMapperImpl() }

    // ViewModels
    viewModel { (savedStateHandle: SavedStateHandle) -> ScenarioDetailViewModel(savedStateHandle) }
}
