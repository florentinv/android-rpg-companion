package com.fvanaldewereld.rpgcompanion.data.scenario.di

import androidx.room.Room
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.repositories.DbScenarioRepository
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.repositories.GoogleDocsRepository
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dbObjectMapper.ChapterMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dbObjectMapper.ChapterMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dbObjectMapper.CharacterMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dbObjectMapper.CharacterMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dbObjectMapper.InformationMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dbObjectMapper.InformationMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dbObjectMapper.PlaceMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dbObjectMapper.PlaceMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dbObjectMapper.ScenarioCompleteMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dbObjectMapper.ScenarioMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dtoMappers.ScenarioDtoMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dtoMappers.ScenarioDtoMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.AuthorModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.AuthorModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.ChapterModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.ChapterModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.ChaptersModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.ChaptersModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.CharacterModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.CharacterModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.CharactersModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.CharactersModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.DescriptionModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.DescriptionModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.InformationModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.InformationModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.PlaceModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.PlaceModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.PlacesModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.PlacesModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.ScenarioModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.ScenarioModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.SummaryModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.SummaryModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.TitleModelMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.modelMappers.TitleModelMapperImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.repositories.GoogleDocsRepositoryImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.repositories.LocalDbScenarioRepositoryImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.googleDocs.GoogleDocsDataSource
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.googleDocs.GoogleDocsDataSourceImpl
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.googleDocs.service.GoogleDocsService
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.localDatabase.AppDatabase
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.localDatabase.dao.ChapterDao
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.localDatabase.dao.CharacterDao
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.localDatabase.dao.PlaceDao
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.localDatabase.dao.ScenarioBaseDao
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.localDatabase.dao.ScenarioDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val SCENARIO_DATA_MODULE = module {

    // Model Mappers
    single<AuthorModelMapper> { AuthorModelMapperImpl() }
    single<ChapterModelMapper> { ChapterModelMapperImpl() }
    single<ChaptersModelMapper> { ChaptersModelMapperImpl() }
    single<CharacterModelMapper> { CharacterModelMapperImpl() }
    single<CharactersModelMapper> { CharactersModelMapperImpl() }
    single<DescriptionModelMapper> { DescriptionModelMapperImpl() }
    single<InformationModelMapper> { InformationModelMapperImpl() }
    single<PlaceModelMapper> { PlaceModelMapperImpl() }
    single<PlacesModelMapper> { PlacesModelMapperImpl() }
    single<ScenarioModelMapper> { ScenarioModelMapperImpl() }
    single<SummaryModelMapper> { SummaryModelMapperImpl() }
    single<TitleModelMapper> { TitleModelMapperImpl() }

    // DtoMapper
    factory<ScenarioDtoMapper> { ScenarioDtoMapperImpl() }

    // DbObjectMapper
    single<ScenarioMapper> { ScenarioCompleteMapperImpl() }
    single<ChapterMapper> { ChapterMapperImpl() }
    single<CharacterMapper> { CharacterMapperImpl() }
    single<InformationMapper> { InformationMapperImpl() }
    single<PlaceMapper> { PlaceMapperImpl() }


    // Sources
    factory<GoogleDocsService> {
        GoogleDocsService(
            androidContext(),
        )
    }
    factory<GoogleDocsDataSource> { GoogleDocsDataSourceImpl() }
    single<AppDatabase> {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "scenario-database",
        ).build()
    }
    single<ScenarioBaseDao> { get<AppDatabase>().scenarioBaseDao() }
    single<ScenarioDao> { ScenarioDao() }
    single<ChapterDao> { get<AppDatabase>().chapterDao() }
    single<CharacterDao> { get<AppDatabase>().characterDao() }
    single<PlaceDao> { get<AppDatabase>().placeDao() }

// Repositories
    factory<GoogleDocsRepository> { GoogleDocsRepositoryImpl() }
    single<DbScenarioRepository> { LocalDbScenarioRepositoryImpl() }
}
