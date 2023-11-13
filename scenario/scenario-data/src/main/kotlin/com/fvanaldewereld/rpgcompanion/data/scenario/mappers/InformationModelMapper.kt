package com.fvanaldewereld.rpgcompanion.data.scenario.mappers

import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.InformationModel
import com.fvanaldewereld.rpgcompanion.data.scenario.dto.InformationDto

interface InformationModelMapper : ModelMapper<InformationDto?, InformationModel?>

internal class InformationModelMapperImpl : InformationModelMapper {
    override fun to(from: InformationDto?) = InformationModel(
        genres = from?.genres,
        nbPlayers = from?.nbPlayers,
        themes = from?.themes,
    )
}