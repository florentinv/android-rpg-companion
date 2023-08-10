package com.fvanaldewereld.rpgcompanion.scenario.feature.mapper

import com.fvanaldewereld.rpgcompanion.common.mapper.Mapper
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.ScenarioModel
import com.fvanaldewereld.rpgcompanion.scenario.feature.model.ScenarioUi

interface ScenarioUiMapper : Mapper<ScenarioModel, ScenarioUi>

class ScenarioUiMapperImpl : ScenarioUiMapper {
    override fun to(from: ScenarioModel) = ScenarioUi(
        documentName = from.documentName,
        tree = from.tree,
    )

}