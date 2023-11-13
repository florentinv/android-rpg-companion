package com.fvanaldewereld.rpgcompanion.lib.domain.scenario

import BasicKoinTest
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.repositories.GoogleDocsRepository
import com.fvanaldewereld.rpgcompanion.lib.domain.scenario.usecases.GetScenarioByUrlUseCase
import com.fvanaldewereld.rpgcompanion.mockFactory.GoogleDocsMockFactory
import com.fvanaldewereld.rpgcompanion.mockFactory.ScenarioModelMockFactory
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.koin.core.KoinApplication
import org.koin.dsl.module
import org.koin.test.inject
import org.mockito.Mockito
import org.mockito.Mockito.mock

class GetScenarioByUrlUseCaseTest : BasicKoinTest() {

    private val mockGoogleDocsRepository by inject<GoogleDocsRepository>()
    private lateinit var getScenarioByUrlUseCase: GetScenarioByUrlUseCase

    override fun KoinApplication.buildModules() {
        modules(
            module {
                single { mock<GoogleDocsRepository>() }
            },
        )
    }

    @BeforeEach
    fun setUp() {
        getScenarioByUrlUseCase =
            GetScenarioByUrlUseCase()
    }

    @Test
    fun `GIVEN mock getGoogleDocsByUrl WHEN executing GetGdocsByUrlUseCase THEN return ScenarioModel`() =
        runBlocking {
            // GIVEN
            Mockito.`when`(mockGoogleDocsRepository.getScenarioByGdocsUrl(GoogleDocsMockFactory.googleDocsUrl))
                .thenReturn(ScenarioModelMockFactory.scenarioModel)

            // WHEN
            val scenario = getScenarioByUrlUseCase(GoogleDocsMockFactory.googleDocsUrl)

            // THEN
            assertEquals(scenario, ScenarioModelMockFactory.scenarioModel)
        }

}
