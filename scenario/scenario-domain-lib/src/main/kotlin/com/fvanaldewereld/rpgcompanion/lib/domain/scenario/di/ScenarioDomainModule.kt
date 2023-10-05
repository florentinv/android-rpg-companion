package com.fvanaldewereld.rpgcompanion.lib.domain.scenario.di

import com.fvanaldewereld.rpgcompanion.lib.domain.scenario.usecases.GetScenarioByUrlUseCase
import com.fvanaldewereld.rpgcompanion.lib.domain.scenario.usecases.GetScenarioListUseCase
import org.koin.dsl.module

val SCENARIO_DOMAIN_LIB_MODULE = module {
    // Usecases
    factory { GetScenarioByUrlUseCase() }
    factory { GetScenarioListUseCase() }
}
