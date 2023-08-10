package com.fvanaldewereld.rpgcompanion.scenario.feature.mapper

import com.fvanaldewereld.rpgcompanion.scenario.ScenarioMockFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScenarioUiMapperImplTest {

    private lateinit var scenarioUiMapper: ScenarioUiMapper

    @BeforeEach
    fun setUp() {
        scenarioUiMapper = ScenarioUiMapperImpl()
    }

    @Test
    @DisplayName("GIVEN ScenarioModel WHEN map THEN return ScenarioUi")
    fun `GIVEN ScenarioModel WHEN map THEN return ScenarioUi`() {
        // GIVEN

        // WHEN
        val scenario = scenarioUiMapper.to(ScenarioMockFactory.scenarioModel)

        // THEN
        assertEquals(scenario, ScenarioMockFactory.scenarioUi)
    }

}