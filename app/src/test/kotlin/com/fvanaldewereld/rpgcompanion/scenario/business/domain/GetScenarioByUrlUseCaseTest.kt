package com.fvanaldewereld.rpgcompanion.scenario.business.domain

import com.fvanaldewereld.rpgcompanion.common.BasicKoinTest
import com.fvanaldewereld.rpgcompanion.scenario.ScenarioMockFactory
import com.fvanaldewereld.rpgcompanion.scenario.business.data.repository.GoogleDocsRepository
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.mapper.ScenarioModelMapper
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

class GetScenarioByUrlUseCaseTest : BasicKoinTest() {

    private val mockGoogleDocsRepository by inject<GoogleDocsRepository>()
    private val mockScenarioModelMapper by inject<ScenarioModelMapper>()
    private lateinit var getScenarioByUrlUseCase: GetScenarioByUrlUseCase

    override fun KoinApplication.buildModules() {
        modules(
            module {
                single { mock<GoogleDocsRepository>() }
                single { mock<ScenarioModelMapper>() }
            },
        )
    }

    @BeforeEach
    fun setUp() {
        getScenarioByUrlUseCase = GetScenarioByUrlUseCase()
    }

    @Test
    @DisplayName("GIVEN url WHEN executing GetGdocsByUrlUseCase THEN return Scenario")
    fun `GIVEN url WHEN executing GetGdocsByUrlUseCase THEN return Scenario`() =
        runBlocking {
            // GIVEN
            Mockito.`when`(mockGoogleDocsRepository.getGoogleDocsById(ScenarioMockFactory.googleDocsDocumentId))
                .thenReturn(ScenarioMockFactory.googleDocsDocument)
            Mockito.`when`(mockScenarioModelMapper.to(ScenarioMockFactory.googleDocsDocument))
                .thenReturn(ScenarioMockFactory.scenarioModel)

            // WHEN
            val scenario = getScenarioByUrlUseCase(ScenarioMockFactory.googleDocsUrl)

            // THEN
            assertEquals(scenario, ScenarioMockFactory.scenarioModel)
        }


}