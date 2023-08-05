package com.fvanaldewereld.rpgcompanion.gdocs.business.data.source

import com.fvanaldewereld.rpgcompanion.gdocs.business.data.model.GdocsModel
import retrofit2.Call

interface GdocsDataSource {
    suspend fun getGdocsById(documentId: String): GdocsModel
}