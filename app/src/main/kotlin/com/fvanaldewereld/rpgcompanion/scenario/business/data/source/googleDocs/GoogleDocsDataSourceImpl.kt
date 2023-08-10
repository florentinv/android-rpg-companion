package com.fvanaldewereld.rpgcompanion.scenario.business.data.source.googleDocs

import com.fvanaldewereld.rpgcompanion.scenario.business.data.source.googleDocs.service.GoogleDocsService
import com.google.api.services.docs.v1.model.Document
import org.koin.core.context.GlobalContext

class GoogleDocsDataSourceImpl : GoogleDocsDataSource {

    private val googleDocsService: GoogleDocsService by GlobalContext.get().inject()

    override suspend fun getGoogleDocsById(documentId: String): Document {
        return googleDocsService.getDocs().documents()[documentId].execute()
    }
}