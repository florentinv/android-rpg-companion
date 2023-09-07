package com.fvanaldewereld.rpgcompanion.scenario

import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.AuthorModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.ChapterModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.ChaptersModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.DescriptionModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.InformationModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.ScenarioModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.SummaryModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.TextType
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.TitleModel
import com.google.api.services.docs.v1.model.Body
import com.google.api.services.docs.v1.model.Document
import com.google.api.services.docs.v1.model.Paragraph
import com.google.api.services.docs.v1.model.ParagraphElement
import com.google.api.services.docs.v1.model.ParagraphStyle
import com.google.api.services.docs.v1.model.StructuralElement
import com.google.api.services.docs.v1.model.TextRun
import java.net.URL

private const val SCENARIO_DOCUMENT_NAME = "Scenario - Example"

private const val SCENARIO_TITLE = "Scenario"

private const val SCENARIO_AUTHOR = "Author"

private const val SCENARIO_SUMMARY = "Summary"

private const val SCENARIO_SUMMARY_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
        "Sed sollicitudin malesuada condimentum. " +
        "Aenean varius turpis a ornare lobortis. " +
        "Curabitur massa turpis, commodo sit amet eleifend dignissim, porttitor ut dolor."

private const val SCENARIO_CHAPTERS = "Chapters"

private const val SCENARIO_CHAPTERS_INTRODUCTION = "Introduction"

private const val SCENARIO_CHAPTERS_INTRODUCTION_TEXT = "Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. " +
        "Proin aliquet at eros pretium porttitor. Vestibulum in elit dictum, faucibus lacus et, fermentum ipsum. " +
        "Phasellus in commodo metus. " +
        "Pellentesque lacinia orci et nisi ultricies, id tempus urna porta."

private const val SCENARIO_INFORMATION = "Information"

private const val NUMBER_OF_PLAYERS_LABEL = "Number of players"
private const val NUMBER_OF_PLAYERS_VALUE = 4

private const val GENRES_LABEL = "Genres"

private const val GENRES_HORROR = "Horror"

private const val GENRES_DRAMA = "Drama"

private const val THEMES_LABEL = "Themes"

private const val THEMES_ALIEN = "Alien"

private const val THEMES_POSSESSION = "Possession"

private const val THEMES_PSYCOLOGICAL = "Psycological"

object ScenarioMockFactory {

    val googleDocsUrl =
        URL("https://docs.google.com/document/d/1EAJa9JbA9tbGNbyv5AHIherdT34C4Ks6hKyIyDlZ7Os/edit#heading=h.6srcydx8zv6e")

    val googleDocsDocumentId = "1EAJa9JbA9tbGNbyv5AHIherdT34C4Ks6hKyIyDlZ7Os"

    val googleDocsDocument: Document = Document()
        .setTitle(SCENARIO_DOCUMENT_NAME)
        .setBody(
            Body().setContent(
                listOf(
                    getStructuralElement(TextType.TITLE.name, SCENARIO_TITLE),
                    getStructuralElement(TextType.SUBTITLE.name, SCENARIO_AUTHOR),
                    getStructuralElement(TextType.HEADING_1.name, SCENARIO_INFORMATION),
                    getStructuralElement(TextType.NORMAL_TEXT.name, "$NUMBER_OF_PLAYERS_LABEL : $NUMBER_OF_PLAYERS_VALUE"),
                    getStructuralElement(TextType.NORMAL_TEXT.name, "$GENRES_LABEL : $GENRES_HORROR / $GENRES_DRAMA"),
                    getStructuralElement(TextType.NORMAL_TEXT.name, "$THEMES_LABEL : $THEMES_ALIEN / $THEMES_POSSESSION / $THEMES_PSYCOLOGICAL"),
                    getStructuralElement(TextType.HEADING_1.name, SCENARIO_SUMMARY),
                    getStructuralElement(TextType.NORMAL_TEXT.name, SCENARIO_SUMMARY_TEXT),
                    getStructuralElement(TextType.HEADING_1.name, SCENARIO_CHAPTERS),
                    getStructuralElement(TextType.HEADING_2.name, SCENARIO_CHAPTERS_INTRODUCTION),
                    getStructuralElement(TextType.NORMAL_TEXT.name, SCENARIO_CHAPTERS_INTRODUCTION_TEXT),
                ),
            ),
        )


    val scenarioModel = ScenarioModel(
        documentName = SCENARIO_DOCUMENT_NAME,
        title = TitleModel(SCENARIO_TITLE),
        author = AuthorModel(SCENARIO_AUTHOR),
        information = InformationModel(
            nbPlayers = NUMBER_OF_PLAYERS_VALUE,
            genres = listOf(GENRES_HORROR, GENRES_DRAMA),
            themes = listOf(THEMES_ALIEN, THEMES_POSSESSION, THEMES_PSYCOLOGICAL),
        ),
        summary = SummaryModel(
            text = DescriptionModel(
                paragraphs = listOf(SCENARIO_SUMMARY_TEXT),
            ),
        ),
        chapters = ChaptersModel(
            listOf(
                ChapterModel(
                    name = SCENARIO_CHAPTERS_INTRODUCTION,
                    description = DescriptionModel(
                        paragraphs = listOf(SCENARIO_CHAPTERS_INTRODUCTION_TEXT),
                    ),
                ),
            ),
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