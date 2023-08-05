package com.fvanaldewereld.rpgcompanion.gdocs.business.data.source

import com.fvanaldewereld.rpgcompanion.common.BasicKoinTest
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.mapper.GdocsMapper
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.source.service.GdocsService
import com.fvanaldewereld.rpgcompanion.gdocs.business.factory.GdocsMockFactory
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.koin.core.KoinApplication
import org.koin.dsl.module
import org.koin.test.inject
import org.mockito.Mockito
import org.mockito.Mockito.mock
import retrofit2.Response

class GdocsDataSourceTest : BasicKoinTest() {

    private val mockGdocsService by inject<GdocsService>()
    private val mockGdocsMapper by inject<GdocsMapper>()

    private lateinit var gdocsDataSource: GdocsDataSource

    override fun KoinApplication.buildModules() {
        modules(
            module {
                single { mock<GdocsService>() }
                single { mock<GdocsMapper>() }
            },
        )
    }

    @BeforeEach
    fun setUp() {
        gdocsDataSource = GdocsDataSourceImpl()
    }

    @Test
    @DisplayName("GIVEN documentId WHEN executing getGdocsById THEN return GdocsModel")
    fun `GIVEN GdocsTO WHEN map THEN return GdocsModel`(): Unit =
        runBlocking {
            // GIVEN
            Mockito.`when`(mockGdocsService.getGdocsById(GdocsMockFactory.gdocsDocumentId))
                .thenReturn(Response.success(GdocsMockFactory.gdocsTO))
            Mockito.`when`(mockGdocsMapper.to(GdocsMockFactory.gdocsTO))
                .thenReturn(GdocsMockFactory.gdocsModel)

            // WHEN
            val gdocs = gdocsDataSource.getGdocsById(GdocsMockFactory.gdocsDocumentId)

            // THEN
            Assertions.assertEquals(gdocs, GdocsMockFactory.gdocsModel)
        }
}