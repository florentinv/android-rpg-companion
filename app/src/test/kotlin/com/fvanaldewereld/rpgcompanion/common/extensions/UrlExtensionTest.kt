package com.fvanaldewereld.rpgcompanion.common.extensions

import com.fvanaldewereld.rpgcompanion.scenarioDetail.ScenarioMockFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UrlExtensionTest {

    @Test
    @DisplayName("GIVEN URL WHEN extractDocumentId THEN return string")
    fun `GIVEN Document WHEN map THEN return Scenario`() {
        // GIVEN

        // WHEN
        val documentId = ScenarioMockFactory.googleDocsUrl.extractDocumentId()

        // THEN
        Assertions.assertEquals(documentId, ScenarioMockFactory.googleDocsDocumentId)
    }

}