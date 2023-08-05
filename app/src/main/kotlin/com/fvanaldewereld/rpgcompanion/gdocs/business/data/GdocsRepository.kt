package com.fvanaldewereld.rpgcompanion.gdocs.business.data

import com.fvanaldewereld.rpgcompanion.gdocs.business.data.model.GdocsModel

fun interface GdocsRepository {
    suspend fun getGdocsById(documentId: String): GdocsModel
}