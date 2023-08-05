package com.fvanaldewereld.rpgcompanion.gdocs.business.data.source.service// Example server-side code (Kotlin using Retrofit as an HTTP client)

import com.fvanaldewereld.rpgcompanion.gdocs.business.data.source.to.GdocsTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

fun interface GdocsService {
    @GET("v1/documents/{documentId}")
    suspend fun getGdocsById(
        @Path("documentId") documentId: String,
    ): Response<GdocsTO>
}

class GdocsServiceException(message: String) : Exception(message)


