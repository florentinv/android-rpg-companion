package com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers

import com.fvanaldewereld.rpgcompanion.mockFactory.ScenarioDtoMockFactory
import com.fvanaldewereld.rpgcompanion.mockFactory.ScenarioModelMockFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DescriptionModelMapperTest {

    private lateinit var descriptionModelMapper: DescriptionModelMapper

    @BeforeEach
    fun setUp() {
        descriptionModelMapper = DescriptionModelMapperImpl()
    }

    @Test
    fun `WHEN map DescriptionDto THEN return DescriptionModel`() {
        // GIVEN

        // WHEN
        val scenario = descriptionModelMapper.to(ScenarioDtoMockFactory.exampleDescriptionDto)

        // THEN
        assertEquals(scenario, ScenarioModelMockFactory.exampleDescriptionModel)
    }
}