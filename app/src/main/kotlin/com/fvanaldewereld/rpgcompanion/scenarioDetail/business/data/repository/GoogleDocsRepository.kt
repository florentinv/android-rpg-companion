package com.fvanaldewereld.rpgcompanion.scenarioDetail.business.data.repository

import com.google.api.services.docs.v1.model.Document

fun interface GoogleDocsRepository {
    suspend fun getGoogleDocsById(documentId: String): Document
}