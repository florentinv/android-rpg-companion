package com.fvanaldewereld.rpgcompanion.scenario.business.domain.mapper

import com.fvanaldewereld.rpgcompanion.common.extensions.extractDocumentId
import com.fvanaldewereld.rpgcompanion.scenario.ScenarioMockFactory
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.net.URL

class ScenarioModelMapperImplTest {

    private lateinit var scenarioModelMapper: ScenarioModelMapper

    @BeforeEach
    fun setUp() {
        scenarioModelMapper = ScenarioModelMapperImpl()
    }

    @Test
    @DisplayName("GIVEN Document WHEN map THEN return ScenarioModel")
    fun `GIVEN Document WHEN map THEN return ScenarioModel`() {
        // GIVEN
        mockkStatic("com.fvanaldewereld.rpgcompanion.common.extensions.UrlExtensionKt")
        every { any<URL>().extractDocumentId() } returns ScenarioMockFactory.googleDocsDocumentId

        // WHEN
        val scenario = scenarioModelMapper.to(ScenarioMockFactory.googleDocsDocument)

        // THEN
        assertEquals(scenario, ScenarioMockFactory.scenarioModel)
    }

}