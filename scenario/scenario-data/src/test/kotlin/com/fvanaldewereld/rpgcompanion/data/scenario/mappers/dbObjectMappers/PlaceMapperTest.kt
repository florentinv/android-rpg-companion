package com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dbObjectMappers

import com.fvanaldewereld.rpgcompanion.mockFactory.ScenarioDbObjectMockFactory
import com.fvanaldewereld.rpgcompanion.mockFactory.ScenarioModelMockFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PlaceMapperTest{

    private lateinit var placeMapper: PlaceMapper

    @BeforeEach
    fun setUp() {
        placeMapper = PlaceMapperImpl()
    }

    @Test
    fun `WHEN map Place THEN return PlaceModel`() {
        // GIVEN

        // WHEN
        val scenario = placeMapper.to(ScenarioDbObjectMockFactory.place1)

        // THEN
        Assertions.assertEquals(scenario, ScenarioModelMockFactory.placeModel1)
    }

    @Test
    fun `WHEN map PlaceModel THEN return Place`() {
        // GIVEN

        // WHEN
        val scenario = placeMapper.from(ScenarioModelMockFactory.placeModel1)

        // THEN
        Assertions.assertEquals(scenario, ScenarioDbObjectMockFactory.place1)
    }
}