package com.fvanaldewereld.rpgcompanion.gdocs.business.data.source

import com.fvanaldewereld.rpgcompanion.gdocs.business.data.model.GdocsModel

fun interface GdocsDataSource {
    suspend fun getGdocsById(documentId: String): GdocsModel
}