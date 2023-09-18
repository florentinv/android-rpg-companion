package com.fvanaldewereld.rpgcompanion.scenario.business.data.repository

import com.fvanaldewereld.rpgcompanion.common.BasicKoinTest
import com.fvanaldewereld.rpgcompanion.scenario.ScenarioMockFactory
import com.fvanaldewereld.rpgcompanion.scenario.business.data.source.googleDocs.GoogleDocsDataSource
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.koin.core.KoinApplication
import org.koin.dsl.module
import org.koin.test.inject
import org.mockito.Mockito

class GoogleDocsRepositoryTest : BasicKoinTest() {

    private val mockGoogleDocsDataSource by inject<GoogleDocsDataSource>()
    private lateinit var googleDocsRepository: GoogleDocsRepository

    override fun KoinApplication.buildModules() {
        modules(
            module {
                single { Mockito.mock<GoogleDocsDataSource>() }
            },
        )
    }

    @BeforeEach
    fun setUp() {
        googleDocsRepository = GoogleDocsRepositoryImpl()
    }

    @Test
    @DisplayName("GIVEN documentId WHEN executing GetGoogleDocsById of GoogleDocsRepository THEN return Document")
    fun `GIVEN documentId WHEN executing GetGoogleDocsById of GoogleDocsRepository THEN return Document`() =
        runBlocking {
            // GIVEN
            Mockito.`when`(mockGoogleDocsDataSource.getGoogleDocsById(ScenarioMockFactory.googleDocsDocumentId))
                .thenReturn(ScenarioMockFactory.googleDocsDocument)

            // WHEN
            val document = googleDocsRepository.getGoogleDocsById(ScenarioMockFactory.googleDocsDocumentId)

            // THEN
            Assertions.assertEquals(document, ScenarioMockFactory.googleDocsDocument)
        }
}