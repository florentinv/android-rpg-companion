package com.fvanaldewereld.rpgcompanion.scenarioList.business.di

import com.fvanaldewereld.rpgcompanion.scenarioList.business.domain.GetScenarioListUseCase
import org.koin.dsl.module

val SCENARIO_LIST_BUSINESS_MODULE = module {
    // Mappers

    // Source

    // Usecase
    factory { GetScenarioListUseCase() }
}
