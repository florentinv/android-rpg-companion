package com.fvanaldewereld.rpgcompanion.scenario

import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.ScenarioModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.TextType
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.TreeModel
import com.fvanaldewereld.rpgcompanion.scenario.feature.model.ScenarioUi
import com.google.api.services.docs.v1.model.Body
import com.google.api.services.docs.v1.model.Document
import com.google.api.services.docs.v1.model.Paragraph
import com.google.api.services.docs.v1.model.ParagraphElement
import com.google.api.services.docs.v1.model.ParagraphStyle
import com.google.api.services.docs.v1.model.StructuralElement
import com.google.api.services.docs.v1.model.TextRun
import java.net.URL

private const val SCENARIO_DOCUMENT_NAME = "Le prix du sang"

private const val SCENARIO_TITLE = "⛧ LE PRIX DU SANG ⛧"

private const val SCENARIO_HEADING_1_1 = "Résumé"

private const val SCENARIO_NORMAL_TEXT_1 = "Les personnages se retrouvent pour un week-end ..."

private const val SCENARIO_HEADING_1_2 = "Introduction"

private const val SCENARIO_NORMAL_TEXT_2 =
    "Les personnages arrivent tous sur le lieu du rendez-vous avec leurs affaires (sacs, valises..)."

object ScenarioMockFactory {

    val googleDocsUrl =
        URL("https://docs.google.com/document/d/1EAJa9JbA9tbGNbyv5AHIherdT34C4Ks6hKyIyDlZ7Os/edit#heading=h.6srcydx8zv6e")

    const val googleDocsDocumentId = "1EAJa9JbA9tbGNbyv5AHIherdT34C4Ks6hKyIyDlZ7Os"

    val googleDocsDocument: Document = Document()
        .setTitle(SCENARIO_DOCUMENT_NAME)
        .setBody(
            Body().setContent(
                listOf(
                    getStructuralElement(TextType.TITLE.name, SCENARIO_TITLE),
                    getStructuralElement(TextType.HEADING_1.name, SCENARIO_HEADING_1_1),
                    getStructuralElement(TextType.NORMAL_TEXT.name, SCENARIO_NORMAL_TEXT_1),
                    getStructuralElement(TextType.HEADING_1.name, SCENARIO_HEADING_1_2),
                    getStructuralElement(TextType.NORMAL_TEXT.name, SCENARIO_NORMAL_TEXT_2),
                ),
            ),
        )


    val scenarioModel = ScenarioModel(
        documentName = SCENARIO_DOCUMENT_NAME,
        tree = TreeModel(
            content = SCENARIO_TITLE,
            children = mutableListOf(
                TreeModel(
                    content = SCENARIO_HEADING_1_1,
                    children = mutableListOf(
                        TreeModel(
                            content = SCENARIO_NORMAL_TEXT_1,
                            children = mutableListOf(),
                            type = TextType.NORMAL_TEXT,
                        ),
                    ),
                    type = TextType.HEADING_1,
                ),
                TreeModel(
                    content = SCENARIO_HEADING_1_2,
                    children = mutableListOf(
                        TreeModel(
                            content = SCENARIO_NORMAL_TEXT_2,
                            children = mutableListOf(),
                            type = TextType.NORMAL_TEXT,
                        ),
                    ),
                    type = TextType.HEADING_1,
                ),
            ),
            type = TextType.TITLE,
        ),
    )

    val scenarioUi = ScenarioUi(
        documentName = SCENARIO_DOCUMENT_NAME,
        tree = TreeModel(
            content = SCENARIO_TITLE,
            children = mutableListOf(
                TreeModel(
                    content = SCENARIO_HEADING_1_1,
                    children = mutableListOf(
                        TreeModel(
                            content = SCENARIO_NORMAL_TEXT_1,
                            children = mutableListOf(),
                            type = TextType.NORMAL_TEXT,
                        ),
                    ),
                    type = TextType.HEADING_1,
                ),
                TreeModel(
                    content = SCENARIO_HEADING_1_2,
                    children = mutableListOf(
                        TreeModel(
                            content = SCENARIO_NORMAL_TEXT_2,
                            children = mutableListOf(),
                            type = TextType.NORMAL_TEXT,
                        ),
                    ),
                    type = TextType.HEADING_1,
                ),
            ),
            type = TextType.TITLE,
        ),
    )

    private fun getStructuralElement(namedStyleType: String, content: String): StructuralElement =
        StructuralElement().setParagraph(
            Paragraph()
                .setParagraphStyle(ParagraphStyle().setNamedStyleType(namedStyleType))
                .setElements(
                    listOf(
                        ParagraphElement().setTextRun(TextRun().setContent(content)),
                    ),
                ),
        )
}