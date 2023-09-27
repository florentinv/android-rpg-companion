package com.fvanaldewereld.rpgcompanion.scenarioList.business.domain

import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain.model.ScenarioModel
import kotlinx.coroutines.delay

class GetScenarioListUseCase {

    suspend operator fun invoke(): List<ScenarioModel> {
        delay(1000)
        return emptyList()
    }
}