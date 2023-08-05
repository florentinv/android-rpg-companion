package com.fvanaldewereld.rpgcompanion.gdocs.business.data.source

import com.fvanaldewereld.rpgcompanion.gdocs.business.data.mapper.GdocsMapper
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.model.GdocsModel
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.source.service.GdocsService
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.source.service.GdocsServiceException
import org.koin.core.context.GlobalContext


class GdocsDataSourceImpl : GdocsDataSource {

    private val gdocsService: GdocsService by GlobalContext.get().inject()
    private val gdocsMapper: GdocsMapper by GlobalContext.get().inject()

    override suspend fun getGdocsById(documentId: String): GdocsModel {
        val response = gdocsService.getGdocsById(documentId)
        if (response.isSuccessful) {
            val data = response.body()
            if (data != null) {
                return gdocsMapper.to(from = data)
            } else {
                val errorMessage = "Error: Document Not Found"
                throw GdocsServiceException(errorMessage)
            }
        } else {
            val errorBody = response.errorBody()?.string()
            val errorMessage = "Error: ${response.code()} - $errorBody"
            throw GdocsServiceException(errorMessage)
        }
    }
}