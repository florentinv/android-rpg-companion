package com.fvanaldewereld.rpgcompanion.gdocs.business.data.mapper

import com.fvanaldewereld.rpgcompanion.gdocs.business.factory.GdocsMockFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GdocsMapperTest {

    private lateinit var gdocsMapper: GdocsMapper

    @BeforeEach
    fun setUp() {
        gdocsMapper = GdocsMapperImpl()
    }

    @Test
    @DisplayName("GIVEN GdocsTO WHEN map THEN return GdocsModel")
    fun `GIVEN GdocsTO WHEN map THEN return GdocsModel`() {
        // GIVEN

        // WHEN
        val gdocs = gdocsMapper.to(GdocsMockFactory.gdocsTO)

        // THEN
        Assertions.assertEquals(gdocs, GdocsMockFactory.gdocsModel)
    }
}