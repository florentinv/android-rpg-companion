package com.fvanaldewereld.rpgcompanion.gdocs.business.data.mapper

import com.fvanaldewereld.rpgcompanion.common.mapper.Mapper
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.model.GdocsModel
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.source.to.GdocsTO

interface GdocsMapper : Mapper<GdocsTO, GdocsModel>

class GdocsMapperImpl : GdocsMapper {
    override fun to(from: GdocsTO) = GdocsModel(
        title = from.title,
    )
}