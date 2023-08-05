package com.fvanaldewereld.rpgcompanion.gdocs.business.data

import com.fvanaldewereld.rpgcompanion.gdocs.business.data.model.GdocsModel
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.source.GdocsDataSource
import org.koin.core.context.GlobalContext

class GdocsRepositoryImpl : GdocsRepository {

    private val gdocsDataSource: GdocsDataSource by GlobalContext.get().inject()

    override suspend fun getGdocsById(documentId: String): GdocsModel {
        return gdocsDataSource.getGdocsById(documentId)
    }
}