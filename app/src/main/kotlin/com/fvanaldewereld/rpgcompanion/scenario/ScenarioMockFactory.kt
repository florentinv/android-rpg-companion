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

object ScenarioMockFactory {

    val googleDocsUrl =
        URL("https://docs.google.com/document/d/1EAJa9JbA9tbGNbyv5AHIherdT34C4Ks6hKyIyDlZ7Os/edit#heading=h.6srcydx8zv6e")

    const val googleDocsDocumentId = "1EAJa9JbA9tbGNbyv5AHIherdT34C4Ks6hKyIyDlZ7Os"

    val googleDocsDocument: Document = Document()
        .setTitle("Le prix du sang")
        .setBody(
            Body().setContent(
                listOf(
                    getStructuralElement(TextType.TITLE.name, "⛧ LE PRIX DU SANG ⛧"),
                    getStructuralElement(TextType.HEADING_1.name, "Résumé"),
                    getStructuralElement(
                        TextType.NORMAL_TEXT.name,
                        "Les personnages se retrouvent pour un week-end ...",
                    ),
                    getStructuralElement(TextType.HEADING_1.name, "Introduction"),
                    getStructuralElement(
                        TextType.NORMAL_TEXT.name,
                        "Les personnages arrivent tous sur le lieu du rendez-vous avec leurs affaires (sacs, valises..).",
                    ),
                ),
            ),
        )


    val scenarioModel = ScenarioModel(
        documentName = "Le prix du sang",
        tree = TreeModel(
            content = "⛧ LE PRIX DU SANG ⛧",
            children = mutableListOf(
                TreeModel(
                    content = "Résumé",
                    children = mutableListOf(
                        TreeModel(
                            content = "Les personnages se retrouvent pour un week-end ...",
                            children = mutableListOf(),
                            type = TextType.NORMAL_TEXT,
                        ),
                    ),
                    type = TextType.HEADING_1,
                ),
                TreeModel(
                    content = "Introduction",
                    children = mutableListOf(
                        TreeModel(
                            content = "Les personnages arrivent tous sur le lieu du rendez-vous avec leurs affaires (sacs, valises..).",
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
        documentName = "Le prix du sang",
        tree = TreeModel(
            content = "⛧ LE PRIX DU SANG ⛧",
            children = mutableListOf(
                TreeModel(
                    content = "Résumé",
                    children = mutableListOf(
                        TreeModel(
                            content = "Les personnages se retrouvent pour un week-end ...",
                            children = mutableListOf(),
                            type = TextType.NORMAL_TEXT,
                        ),
                    ),
                    type = TextType.HEADING_1,
                ),
                TreeModel(
                    content = "Introduction",
                    children = mutableListOf(
                        TreeModel(
                            content = "Les personnages arrivent tous sur le lieu du rendez-vous avec leurs affaires (sacs, valises..).",
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