package com.fvanaldewereld.rpgcompanion.data.scenario.di

import com.fvanaldewereld.rpgcompanion.api.domain.scenario.repositories.GoogleDocsRepository
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.AuthorModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.AuthorModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.ChapterModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.ChapterModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.ChaptersModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.ChaptersModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.CharacterModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.CharacterModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.CharactersModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.CharactersModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.DescriptionModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.DescriptionModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.InformationModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.InformationModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.PlaceModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.PlaceModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.PlacesModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.PlacesModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.ScenarioDtoMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.ScenarioDtoMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.ScenarioModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.ScenarioModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.SummaryModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.SummaryModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.TitleModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.TitleModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.repositories.GoogleDocsRepositoryImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.googleDocs.GoogleDocsDataSource
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.googleDocs.GoogleDocsDataSourceImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.googleDocs.service.GoogleDocsService
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val SCENARIO_DATA_MODULE = module {
    // Mappers
    single<AuthorModelMapper> { AuthorModelMapperImpl() }
    single<ChapterModelMapper> { ChapterModelMapperImpl() }
    single<ChaptersModelMapper> { ChaptersModelMapperImpl() }
    single<CharacterModelMapper> { CharacterModelMapperImpl() }
    single<CharactersModelMapper> { CharactersModelMapperImpl() }
    single<DescriptionModelMapper> { DescriptionModelMapperImpl() }
    single<InformationModelMapper> { InformationModelMapperImpl() }
    single<PlaceModelMapper> { PlaceModelMapperImpl() }
    single<PlacesModelMapper> { PlacesModelMapperImpl() }
    single<ScenarioDtoMapper> { ScenarioDtoMapperImpl() }
    single<ScenarioModelMapper> { ScenarioModelMapperImpl() }
    single<SummaryModelMapper> { SummaryModelMapperImpl() }
    single<TitleModelMapper> { TitleModelMapperImpl() }

    // Sources
    single<GoogleDocsService> {
        GoogleDocsService(
            androidContext(),
        )
    }
    factory<GoogleDocsDataSource> { GoogleDocsDataSourceImpl() }

    // Repositories
    factory<GoogleDocsRepository> { GoogleDocsRepositoryImpl() }
}
