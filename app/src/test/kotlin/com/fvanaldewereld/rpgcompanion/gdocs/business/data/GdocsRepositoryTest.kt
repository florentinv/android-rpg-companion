package com.fvanaldewereld.rpgcompanion.gdocs.business.data

import com.fvanaldewereld.rpgcompanion.common.BasicKoinTest
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.source.GdocsDataSource
import com.fvanaldewereld.rpgcompanion.gdocs.business.factory.GdocsMockFactory
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.koin.core.KoinApplication
import org.koin.dsl.module
import org.koin.test.inject
import org.mockito.Mockito
import org.mockito.Mockito.mock

class GdocsRepositoryTest : BasicKoinTest() {

    private val mockGdocsDataSource by inject<GdocsDataSource>()

    private lateinit var gdocsRepository: GdocsRepository

    override fun KoinApplication.buildModules() {
        modules(
            module {
                single { mock<GdocsDataSource>() }
            },
        )
    }

    @BeforeEach
    fun setUp() {
        gdocsRepository = GdocsRepositoryImpl()
    }

    @Test
    @DisplayName("GIVEN documentId WHEN executing getGdocsById THEN return GdocsModel")
    fun `GIVEN documentId WHEN executing getGdocsById THEN return GdocsModel`(): Unit =
        runBlocking {
            // GIVEN
            Mockito.`when`(mockGdocsDataSource.getGdocsById(GdocsMockFactory.gdocsDocumentId))
                .thenReturn(GdocsMockFactory.gdocsModel)

            // WHEN
            val gdocs = gdocsRepository.getGdocsById(GdocsMockFactory.gdocsDocumentId)

            // THEN
            assertEquals(gdocs, GdocsMockFactory.gdocsModel)
        }
}