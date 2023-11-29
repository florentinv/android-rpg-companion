package com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers

import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.PlaceModel
import com.fvanaldewereld.rpgcompanion.data.scenario.dto.PlaceEntity
import org.koin.core.context.GlobalContext

interface PlaceModelMapper : ModelMapper<PlaceEntity?, PlaceModel>

internal class PlaceModelMapperImpl : PlaceModelMapper {
    private val descriptionModelMapper: DescriptionModelMapper by GlobalContext.get().inject()

    override fun to(from: PlaceEntity?) = PlaceModel(
        name = from?.name,
        description = descriptionModelMapper.to(from?.description),
    )
}