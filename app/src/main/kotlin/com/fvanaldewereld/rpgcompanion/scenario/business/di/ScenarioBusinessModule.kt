package com.fvanaldewereld.rpgcompanion.scenario.business.di

import com.fvanaldewereld.rpgcompanion.scenario.business.data.repository.GoogleDocsRepository
import com.fvanaldewereld.rpgcompanion.scenario.business.data.repository.GoogleDocsRepositoryImpl
import com.fvanaldewereld.rpgcompanion.scenario.business.data.source.googleDocs.GoogleDocsDataSource
import com.fvanaldewereld.rpgcompanion.scenario.business.data.source.googleDocs.GoogleDocsDataSourceImpl
import com.fvanaldewereld.rpgcompanion.scenario.business.data.source.googleDocs.service.GoogleDocsService
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.GetScenarioByUrlUseCase
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.mapper.ScenarioModelMapper
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.mapper.ScenarioModelMapperImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val SCENARIO_BUSINESS_MODULE = module {
    // Mappers
    single<ScenarioModelMapper> { ScenarioModelMapperImpl() }

    // Source
    single<GoogleDocsService> { GoogleDocsService(androidContext()) }
    factory<GoogleDocsDataSource> { GoogleDocsDataSourceImpl() }
    factory<GoogleDocsRepository> { GoogleDocsRepositoryImpl() }

    // Usecase
    factory { GetScenarioByUrlUseCase() }
}
