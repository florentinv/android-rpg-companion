package com.fvanaldewereld.rpgcompanion.scenario.business.domain.mapper

import com.fvanaldewereld.rpgcompanion.common.mapper.Mapper
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.AuthorModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.ChapterModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.ChaptersModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.CharacterModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.CharactersModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.DescriptionModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.InformationModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.PlaceModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.PlacesModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.ScenarioElement
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.ScenarioModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.SummaryModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.TextType
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.TitleModel
import com.google.api.services.docs.v1.model.Document
import com.google.api.services.docs.v1.model.StructuralElement

interface ScenarioModelMapper : Mapper<Document, ScenarioModel>

private const val TITLE = "TITLE"
private const val AUTHOR = "AUTHOR"
private const val INFORMATION = "INFORMATION"
private const val SUMMARY = "SUMMARY"
private const val CHARACTERS = "CHARACTERS"
private const val PLACES = "PLACES"
private const val CHAPTERS = "CHAPTERS"

private const val NUMBER_OF_PLAYERS = "NUMBER OF PLAYERS"

private const val GENRES = "GENRES"

private const val THEMES = "THEMES"


class ScenarioModelMapperImpl : ScenarioModelMapper {

    private val scenarioElements = mutableMapOf<String, ScenarioElement?>()

    private var title: String? = null
    private var author: String? = null
    private var nbPlayers = 1
    private var genres = emptyList<String>()
    private var themes = emptyList<String>()

    private val summaryDescriptionParagraphs = mutableListOf<String>()

    private val characters = mutableListOf<CharacterModel>()
    private var lastCharacterName: String? = null
    private val lastCharacterDescriptionParagraphs = mutableListOf<String>()

    private val places = mutableListOf<PlaceModel>()
    private var lastPlaceName: String? = null
    private val lastPlaceDescriptionParagraphs = mutableListOf<String>()


    private val chapters = mutableListOf<ChapterModel>()
    private var lastChapterName: String? = null
    private val lastChapterDescriptionParagraphs = mutableListOf<String>()

    override fun to(from: Document): ScenarioModel {
        from.body.content.forEach { structuralElement ->
            val namedStyleType = structuralElement?.paragraph?.paragraphStyle?.namedStyleType
            val paragraphText = getTextFromStructuralElement(structuralElement)
            if (paragraphText.isNotBlank()) {
                when (namedStyleType) {
                    TextType.TITLE.name -> {
                        title = paragraphText
                    }

                    TextType.SUBTITLE.name -> {
                        author = paragraphText
                    }

                    TextType.HEADING_1.name -> {
                        addLastItemForLastKey()
                        addNewScenarioElement(paragraphText)
                    }

                    TextType.HEADING_2.name -> {
                        updateLastScenarioSubElementName(paragraphText)
                    }

                    TextType.NORMAL_TEXT.name -> {
                        updateLastScenarioSubElementDescription(paragraphText)
                    }
                }
            }
        }
        addLastItemForLastKey()
        setupScenarioElements()

        return ScenarioModel(
            author = scenarioElements[AUTHOR] as? AuthorModel,
            characters = scenarioElements[CHARACTERS] as? CharactersModel,
            chapters = scenarioElements[CHAPTERS] as? ChaptersModel,
            documentName = from.title,
            information = scenarioElements[INFORMATION] as? InformationModel,
            places = scenarioElements[PLACES] as? PlacesModel,
            summary = scenarioElements[SUMMARY] as? SummaryModel,
            title = scenarioElements[TITLE] as? TitleModel,
        )
    }

    private fun setupScenarioElements() {
        scenarioElements[TITLE] = title?.let { TitleModel(value = it) }
        scenarioElements[AUTHOR] = author?.let { AuthorModel(name = it) }
        scenarioElements[INFORMATION] = InformationModel(nbPlayers = nbPlayers, genres = genres, themes = themes)
        scenarioElements[SUMMARY] = if (summaryDescriptionParagraphs.isNotEmpty()) SummaryModel(text = DescriptionModel(summaryDescriptionParagraphs)) else null
        scenarioElements[CHARACTERS] = if (characters.isNotEmpty()) CharactersModel(characters = characters) else null
        scenarioElements[PLACES] = if (places.isNotEmpty()) PlacesModel(places = places) else null
        scenarioElements[CHAPTERS] = if (chapters.isNotEmpty()) ChaptersModel(chapters = chapters) else null
    }

    private fun updateLastScenarioSubElementDescription(paragraphText: String) {
        val lastKey = scenarioElements.keys.lastOrNull()
        when (lastKey) {
            INFORMATION -> {
                getInformationElement(paragraphText)
            }

            CHARACTERS -> {
                lastCharacterDescriptionParagraphs.add(paragraphText)
            }

            PLACES -> {
                lastPlaceDescriptionParagraphs.add(paragraphText)
            }

            CHAPTERS -> {
                lastChapterDescriptionParagraphs.add(paragraphText)
            }

            SUMMARY -> {
                summaryDescriptionParagraphs.add(paragraphText)
            }

            else -> {
                // DO NOTHING
            }
        }
    }

    private fun updateLastScenarioSubElementName(paragraphText: String) {
        val lastKey = scenarioElements.keys.lastOrNull()
        when (lastKey) {
            CHARACTERS -> {
                addLastCharacter()
                lastCharacterName = paragraphText
            }

            PLACES -> {
                addLastPlace()
                lastPlaceName = paragraphText
            }

            CHAPTERS -> {
                addLastChapter()
                lastChapterName = paragraphText
            }

            else -> {
                // DO NOTHING
            }
        }
    }

    private fun addNewScenarioElement(paragraphText: String) {
        when (paragraphText.uppercase()) {
            INFORMATION -> {
                scenarioElements[INFORMATION] = null
            }

            SUMMARY -> {
                scenarioElements[SUMMARY] = null
            }

            CHARACTERS -> {
                scenarioElements[CHARACTERS] = null
            }

            PLACES -> {
                scenarioElements[PLACES] = null
            }

            CHAPTERS -> {
                scenarioElements[CHAPTERS] = null
            }

        }
    }

    private fun addLastItemForLastKey() {
        val lastKey = scenarioElements.keys.lastOrNull()
        when (lastKey) {
            CHARACTERS -> {
                addLastCharacter()
            }

            PLACES -> {
                addLastPlace()
            }

            CHAPTERS -> {
                addLastChapter()
            }

            else -> {
                // DO NOTHING
            }
        }
    }

    private fun addLastChapter() {
        if (lastChapterName != null) {
            chapters.add(
                ChapterModel(
                    name = lastChapterName.toString(),
                    description = DescriptionModel(paragraphs = lastChapterDescriptionParagraphs.toList()),
                ),
            )
            lastChapterName = null
            lastChapterDescriptionParagraphs.clear()
        }
    }

    private fun addLastPlace() {
        if (lastPlaceName != null) {
            places.add(
                PlaceModel(
                    name = lastPlaceName.toString(),
                    description = DescriptionModel(paragraphs = lastPlaceDescriptionParagraphs.toList()),
                ),
            )
            lastPlaceName = null
            lastPlaceDescriptionParagraphs.clear()
        }
    }

    private fun addLastCharacter() {
        if (lastCharacterName != null) {
            characters.add(
                CharacterModel(
                    name = lastCharacterName.toString(),
                    description = DescriptionModel(paragraphs = lastCharacterDescriptionParagraphs.toList()),
                ),
            )
            lastCharacterName = null
            lastCharacterDescriptionParagraphs.clear()
        }
    }

    private fun getInformationElement(text: String) {
        val stringList = text.split(":")
        val label = stringList[0].trim()
        val values = stringList[1].trim()
        when (label.uppercase()) {
            NUMBER_OF_PLAYERS -> nbPlayers = values.toInt()
            GENRES -> genres = values.split("/").map { it.trim() }
            THEMES -> themes = values.split("/").map { it.trim() }
        }
    }

    private fun getTextFromStructuralElement(structuralElement: StructuralElement): String {
        var text = ""
        structuralElement.paragraph?.elements?.forEach { element ->
            element?.textRun?.content?.let { elementText -> text += elementText }
        }
        return text.replace("\n", "").trim()
    }
}