package com.fvanaldewereld.rpgcompanion.gdocs.business.domain

import com.fvanaldewereld.rpgcompanion.gdocs.business.data.GdocsRepository
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.model.GdocsModel
import org.koin.core.context.GlobalContext

class GetGdocsByUrlUseCase {
    private val gdocsRepository : GdocsRepository by GlobalContext.get().inject()

    suspend fun execute(documentUrl : String): GdocsModel{
        val documentId = extractDocumentIdFromUrl(documentUrl)
        return gdocsRepository.getGdocsById(documentId)
    }

    private fun extractDocumentIdFromUrl(url: String): String {
        val regex = "/d/(.*?)/edit".toRegex()
        val matchResult = regex.find(url)
        return matchResult?.groups?.get(1)?.value ?: ""
    }
}