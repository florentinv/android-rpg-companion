package com.fvanaldewereld.rpgcompanion.scenario.business.data.source.googleDocs

import com.google.api.services.docs.v1.model.Document

fun interface GoogleDocsDataSource {
    suspend fun getGoogleDocsById(documentId: String): Document
}