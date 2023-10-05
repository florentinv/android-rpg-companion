package com.fvanaldewereld.rpgcompanion.lib.domain.scenario.usecases

import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.ScenarioModel
import kotlinx.coroutines.delay

class GetScenarioListUseCase {

    suspend operator fun invoke(): List<ScenarioModel> {
        delay(1000) //TODO remove when tested
        return emptyList()
    }
}
