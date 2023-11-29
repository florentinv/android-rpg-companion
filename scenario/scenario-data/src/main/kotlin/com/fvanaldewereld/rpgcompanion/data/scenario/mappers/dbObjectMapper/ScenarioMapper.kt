package com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dbObjectMapper

import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.AuthorModel
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.ChaptersModel
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.CharactersModel
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.DescriptionModel
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.PlacesModel
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.ScenarioModel
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.SummaryModel
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.TitleModel
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.localDatabase.entities.ScenarioBase
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.localDatabase.relations.Scenario
import org.koin.core.context.GlobalContext

interface ScenarioMapper : DbObjectMapper<Scenario, ScenarioModel>

internal class ScenarioCompleteMapperImpl : ScenarioMapper {

    private val chapterMapper: ChapterMapper by GlobalContext.get().inject()
    private val characterMapper: CharacterMapper by GlobalContext.get().inject()
    private val informationMapper: InformationMapper by GlobalContext.get().inject()
    private val placeMapper: PlaceMapper by GlobalContext.get().inject()

    override fun to(from: Scenario) = ScenarioModel(
        id = from.scenarioBase.id,
        author = AuthorModel(name = from.scenarioBase.author),
        chapters = ChaptersModel(chapters = from.chapters?.map { chapterMapper.to(from = it) }),
        characters = CharactersModel(characters = from.characters?.map { characterMapper.to(from = it) }),
        documentName = from.scenarioBase.documentName,
        information = from.scenarioBase.information?.let { informationMapper.to(from = it) },
        places = PlacesModel(places = from.places?.map { placeMapper.to(it) }),
        summary = SummaryModel(text = DescriptionModel(from.scenarioBase.summary)),
        title = TitleModel(value = from.scenarioBase.title),
    )

    override fun from(to: ScenarioModel): Scenario {
        val chapters = to.chapters?.chapters?.map { chapterMapper.from(it) }
        val characters = to.characters?.characters?.map { characterMapper.from(it) }
        val places = to.places?.places?.map { placeMapper.from(it) }
        val scenarioBase = ScenarioBase(
            author = to.author?.name,
            documentName = to.documentName,
            information = to.information?.let { informationMapper.from(to = it) },
            summary = to.summary?.text?.paragraphs,
            title = to.title?.value,
        )
        return Scenario(
            chapters = chapters,
            characters = characters,
            places = places,
            scenarioBase = scenarioBase,
        )
    }

}
