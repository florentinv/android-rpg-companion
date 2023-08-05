package com.fvanaldewereld.rpgcompanion.gdocs.business.domain

import com.fvanaldewereld.rpgcompanion.common.BasicKoinTest
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.GdocsRepository
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

class GetGdocsByUrlUseCaseTest : BasicKoinTest() {

    private val mockGdocsRepository by inject<GdocsRepository>()
    private lateinit var getGdocsByUrlUseCase: GetGdocsByUrlUseCase

    override fun KoinApplication.buildModules() {
        modules(
            module {
                single { mock<GdocsRepository>() }
            },
        )
    }

    @BeforeEach
    fun setUp() {
        getGdocsByUrlUseCase = GetGdocsByUrlUseCase()
    }

    @Test
    @DisplayName("GIVEN url WHEN executing GetGdocsByUrlUseCase THEN return GdocsModel")
    fun `GIVEN url WHEN executing GetGdocsByUrlUseCase THEN return GdocsModel`() =
        runBlocking {
            // GIVEN
            Mockito.`when`(mockGdocsRepository.getGdocsById(GdocsMockFactory.gdocsDocumentId))
                .thenReturn(GdocsMockFactory.gdocsModel)

            // WHEN
            val gdocs = getGdocsByUrlUseCase.execute(GdocsMockFactory.gdocsUrl)

            // THEN
            assertEquals(gdocs, GdocsMockFactory.gdocsModel)
        }


}