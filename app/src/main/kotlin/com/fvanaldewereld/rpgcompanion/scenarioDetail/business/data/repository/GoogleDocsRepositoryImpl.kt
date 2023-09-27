package com.fvanaldewereld.rpgcompanion.scenarioDetail.business.data.repository

import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.data.source.googleDocs.GoogleDocsDataSource
import com.google.api.services.docs.v1.model.Document
import org.koin.core.context.GlobalContext

class GoogleDocsRepositoryImpl : GoogleDocsRepository {

    private val googleDocsDataSource: GoogleDocsDataSource by GlobalContext.get()
        .inject()

    override suspend fun getGoogleDocsById(documentId: String): Document {
        return googleDocsDataSource.getGoogleDocsById(documentId)
    }

}